package com.techsmart.billapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth.consumer.ProtectedResourceDetails;
import org.springframework.security.oauth.consumer.client.OAuthRestTemplate;
import org.springframework.stereotype.Component;

import com.techsmart.billapp.model.Notification;
import com.techsmart.billapp.model.Notification.Type;

@Component
public class AppDirectOAuthClient {

	@Autowired
	private ProtectedResourceDetails protectedResourceDetails;

	public Notification getNotification(String url, Type type) {
		final OAuthRestTemplate rest = new OAuthRestTemplate(protectedResourceDetails);
		final Notification notification = rest.getForObject(url, Notification.class);
		if (!type.equals(notification.type)) {
			throw new BadNotificationType(type, notification.type);
		}
		return notification;
	}

}