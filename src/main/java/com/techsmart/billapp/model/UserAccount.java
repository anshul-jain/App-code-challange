package com.techsmart.billapp.model;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserAccount {
	
	private Long id;
	private String openId;
	private String firstname;
	private String lastname;
	private String email;
	private Long subscriptionId;

    public UserAccount() {
    }

    public UserAccount(String openId,String firstname,String lastname,String email,Long subscriptionId) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.openId = openId;
        this.email = email;
        this.subscriptionId = subscriptionId;
    }
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getOpenId() {
		return openId;
	}

	public void setOpenId(String openId) {
		this.openId = openId;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getSubscriptionId() {
		return subscriptionId;
	}

	public void setSubscriptionId(Long subscriptionId) {
		this.subscriptionId = subscriptionId;
	}
}