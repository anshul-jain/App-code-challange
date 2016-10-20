package com.techsmart.billapp.dao;

import com.techsmart.billapp.model.Subscription;

public interface ISubscriptionDao {

	Subscription readByOpenId(long id);
	
	Long create(Subscription subscription);
	
	boolean delete(Long id);
}
