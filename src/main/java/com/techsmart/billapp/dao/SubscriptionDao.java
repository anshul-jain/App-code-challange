package com.techsmart.billapp.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.techsmart.billapp.model.Subscription;
import com.techsmart.billapp.model.SubscriptionRowMapper;

@Repository
public class SubscriptionDao extends ApplicationDao implements ISubscriptionDao {

	// Queries Also kept in folder structure in form of properties files
	Logger log = LoggerFactory.getLogger(ApplicationDao.class);
	
	/**
	 * @param id subscription to get object
	 * @return Subscription object for input id
	 */

	@Override
	public Subscription readByOpenId(long id) {
		log.info("read By OpenId "+id);
		String sql = "Select * from Subscription " + "where id = ?";
		Object[] args = { id };
		Subscription subscription = (Subscription) getJdbcTemplate().queryForObject(sql, args,
				new SubscriptionRowMapper<Object>());

		return subscription;
	}

	@Override
	public Long create(Subscription subscription) {
		log.info("create new subsription  ");
		String sql = "INSERT INTO Subscription " + "(Company_name, Edition, MarketBaseUrl) VALUES (?, ?, ?)";
		Object[] args = { subscription.getCompanyName(), subscription.getEdition(),
				subscription.getMarketPlaceBaseUrl() };
		return (long) getJdbcTemplate().update(sql, args);
	}

	@Override
	public boolean delete(Long id) {
		String sql = "DELETE FROM Subscription " + "where id = ?";
		Object[] args = { id };
		int i = getJdbcTemplate().update(sql, args);
		if (i != 0)
			return true;
		else
			return false;
	}
}