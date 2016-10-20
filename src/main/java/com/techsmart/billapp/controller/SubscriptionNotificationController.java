package com.techsmart.billapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.techsmart.billapp.model.AppDirectUser;
import com.techsmart.billapp.model.Company;
import com.techsmart.billapp.model.ErrorResponse;
import com.techsmart.billapp.model.ErrorResponse.ErrorCode;
import com.techsmart.billapp.model.Notification;
import com.techsmart.billapp.model.Notification.Flag;
import com.techsmart.billapp.model.Order;
import com.techsmart.billapp.model.Response;
import com.techsmart.billapp.model.Subscription;
import com.techsmart.billapp.model.SuccessResponse;
import com.techsmart.billapp.model.UserAccount;
import com.techsmart.billapp.service.AppDirectOAuthClient;
import com.techsmart.billapp.service.ISubscriptionService;
import com.techsmart.billapp.service.IUserAccountService;

@RestController
@RequestMapping("api/notification/subscription")
public class SubscriptionNotificationController {

	@Autowired
	private ISubscriptionService subscriptionService;
	@Autowired
	private IUserAccountService userAccountService;
	@Autowired
	private AppDirectOAuthClient oAuthClient;

	@RequestMapping("create")
	public ResponseEntity<Response> create(@RequestParam("url") String url) {
		try {
			final Notification notification = oAuthClient.getNotification(url, Notification.Type.SUBSCRIPTION_ORDER);

			final AppDirectUser creator = notification.creator;
			final Company company = notification.payload.company;
			final Order order = notification.payload.order;

			if (Flag.STATELESS.equals(notification.flag)) {
				return new ResponseEntity<>(new SuccessResponse(), HttpStatus.OK);
			}

			if (userAccountService.readByOpenId(creator.openId) != null) {
				return new ResponseEntity<>(new ErrorResponse(ErrorCode.USER_ALREADY_EXISTS, ""), HttpStatus.CONFLICT);
			}

			final Long subscriptionId = subscriptionService
					.create(new Subscription(company.name, order.editionCode, notification.marketplace.baseUrl));
			userAccountService.create(new UserAccount(creator.openId, creator.firstName, creator.lastName,
					creator.email, subscriptionId));

			return new ResponseEntity<>(new SuccessResponse(subscriptionId.toString()), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(
					new ErrorResponse(ErrorCode.UNKNOWN_ERROR, String.format("Exception thrown %s", e.getMessage())),
					HttpStatus.OK);
		}
	}

	@RequestMapping("cancel")
	public ResponseEntity<Response> cancel(@RequestParam("url") String url) {
		try {
			final Notification notification = oAuthClient.getNotification(url, Notification.Type.SUBSCRIPTION_CANCEL);

			if (Flag.STATELESS.equals(notification.flag)) {
				return new ResponseEntity<>(new SuccessResponse(), HttpStatus.OK);
			}

			final Long subscriptionId = Long.valueOf(notification.payload.account.accountIdentifier);

			userAccountService.deleteBySubscriptionId(subscriptionId);
			if (subscriptionService.delete(subscriptionId)) {
				return new ResponseEntity<>(new SuccessResponse(), HttpStatus.OK);
			} else {
				return new ResponseEntity<>(new ErrorResponse(ErrorCode.ACCOUNT_NOT_FOUND,
						"The account " + subscriptionId + " could not be found."), HttpStatus.OK);
			}
		} catch (Exception e) {
			return new ResponseEntity<>(
					new ErrorResponse(ErrorCode.UNKNOWN_ERROR, String.format("Exception thrown %s", e.getMessage())),
					HttpStatus.OK);
		}
	}
}
