package com.techsmart.billapp.model;

import java.util.List;

public class Subscription {

	private Long id;
	private String companyName;
	private String edition;
	private String status;
	private String marketPlaceBaseUrl;
	private List<UserAccount> users;

    public Subscription() {
    }

    public Subscription(String companyName,String edition,String marketPlaceBaseUrl) {
        this.companyName = companyName;
        this.edition = edition;
        this.marketPlaceBaseUrl = marketPlaceBaseUrl;
    }
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getEdition() {
		return edition;
	}

	public void setEdition(String edition) {
		this.edition = edition;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMarketPlaceBaseUrl() {
		return marketPlaceBaseUrl;
	}

	public void setMarketPlaceBaseUrl(String marketPlaceBaseUrl) {
		this.marketPlaceBaseUrl = marketPlaceBaseUrl;
	}

	public List<UserAccount> getUsers() {
		return users;
	}

	public void setUsers(List<UserAccount> users) {
		this.users = users;
	}
}