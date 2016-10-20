package com.techsmart.billapp.dao;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class ApplicationDao extends JdbcDaoSupport {

	// CAN ALSO ADD GENERIC METHODS USED BY ALL DAO 
	Logger log = LoggerFactory.getLogger(ApplicationDao.class);
	
	@Autowired
	@Qualifier("dataSource")
	private DataSource dataSource;
	
	
	@PostConstruct
	void init() {
		setDataSource(dataSource);
	}

}