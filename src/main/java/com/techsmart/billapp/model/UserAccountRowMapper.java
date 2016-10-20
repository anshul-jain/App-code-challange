package com.techsmart.billapp.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class UserAccountRowMapper<T> implements RowMapper<T>
{
	@SuppressWarnings("unchecked")
	public T mapRow(ResultSet rs, int rowNum) throws SQLException {
		UserAccount userAccount = new UserAccount();
		userAccount.setId(rs.getLong("Id"));
		userAccount.setFirstname(rs.getString("Firstname"));
		userAccount.setLastname(rs.getString("Lastname"));
		userAccount.setEmail(rs.getString("Email"));
		userAccount.setOpenId(rs.getString("OpenId"));
		userAccount.setSubscriptionId(rs.getLong("SubscriptionId"));
		return (T) userAccount;
	}
}
