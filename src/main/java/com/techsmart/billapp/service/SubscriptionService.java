package com.techsmart.billapp.service;

import org.springframework.stereotype.Service;

import com.techsmart.billapp.dao.ISubscriptionDao;
import com.techsmart.billapp.model.Subscription;

@Service
public class SubscriptionService implements ISubscriptionService {

	private ISubscriptionDao subscriptionDao;

	@Override
	public Subscription readByOpenId(long id) {
		return subscriptionDao.readByOpenId(id);
	}

	@Override
	public Long create(Subscription subscription) {
		return subscriptionDao.create(subscription);
	}

	@Override
	public boolean delete(Long id) {
		return subscriptionDao.delete(id);
	}

}
