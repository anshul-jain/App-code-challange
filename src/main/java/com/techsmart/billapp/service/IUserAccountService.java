package com.techsmart.billapp.service;

import com.techsmart.billapp.model.UserAccount;

public interface IUserAccountService {

	UserAccount readByOpenId(String openId);

	Long create(UserAccount userAccount);

	boolean deleteBySubscriptionId(Long subscriptionId);
}
