package com.techsmart.billapp.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class SubscriptionRowMapper<T> implements RowMapper<T>
{
	@SuppressWarnings("unchecked")
	public T mapRow(ResultSet rs, int rowNum) throws SQLException {
		Subscription subscription = new Subscription();
		subscription.setId(rs.getLong("Id"));
		subscription.setCompanyName(rs.getString("Company_name"));
		subscription.setEdition(rs.getString("Edition"));
		subscription.setMarketPlaceBaseUrl(rs.getString("MarketBaseUrl"));
		subscription.setStatus(rs.getString("Status"));
		return (T) subscription;
	}
}
