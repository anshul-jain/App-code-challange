package com.techsmart.billapp.service;

import com.techsmart.billapp.dao.IUserAccountDao;
import com.techsmart.billapp.model.UserAccount;

public class UserAccountService implements IUserAccountService{

	private IUserAccountDao userAccountDao;
	
	@Override
	public UserAccount readByOpenId(String openId) {
		return userAccountDao.readByOpenId(openId);
	}

	@Override
	public Long create(UserAccount userAccount) {
		return userAccountDao.create(userAccount);
	}

	@Override
	public boolean deleteBySubscriptionId(Long subscriptionId) {
		return userAccountDao.deleteBySubscriptionId(subscriptionId);
	}

}
