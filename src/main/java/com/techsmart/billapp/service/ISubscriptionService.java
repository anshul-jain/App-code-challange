package com.techsmart.billapp.service;

import com.techsmart.billapp.model.Subscription;

public interface ISubscriptionService {

	Subscription readByOpenId(long id);
	
	Long create(Subscription subscription);
	
	boolean delete(Long id);
	
}
