package com.techsmart.billapp.dao;

import com.techsmart.billapp.model.UserAccount;

public interface IUserAccountDao {

	UserAccount readByOpenId(String openId);

	Long create(UserAccount userAccount);

	boolean deleteBySubscriptionId(Long subscriptionId);
}
