package com.techsmart.billapp.dao;

import com.techsmart.billapp.model.UserAccount;
import com.techsmart.billapp.model.UserAccountRowMapper;

public class UserAccountDao extends ApplicationDao implements IUserAccountDao {

	@Override
	public UserAccount readByOpenId(String openId) {
		String sql = "Select * from UserAccount " + "where id = ?";
		Object[] args = { openId };
		UserAccount userAccount = (UserAccount) getJdbcTemplate().queryForObject(sql, args,
				new UserAccountRowMapper<Object>());

		return userAccount;
	}

	@Override
	public Long create(UserAccount userAccount) {
		String sql = "INSERT INTO Subscription "
				+ "(Firstname, Lastname, Email,OpenId,SubscriptionId) VALUES (?, ?, ?,?,?)";
		Object[] args = { userAccount.getFirstname(), userAccount.getLastname(), userAccount.getEmail(),
				userAccount.getOpenId(), userAccount.getSubscriptionId() };
		return (long) getJdbcTemplate().update(sql, args);
	}

	@Override
	public boolean deleteBySubscriptionId(Long subscriptionId) {
		String sql = "DELETE FROM UserAccount " + "where id = ?";
		Object[] args = { subscriptionId };
		int i = getJdbcTemplate().update(sql, args);
		if (i != 0)
			return true;
		else
			return false;
	}
}
