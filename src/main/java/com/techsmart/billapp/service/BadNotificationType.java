package com.techsmart.billapp.service;

import com.techsmart.billapp.model.Notification.Type;

@SuppressWarnings("serial")
public class BadNotificationType extends RuntimeException {

	public BadNotificationType(Type expected, Type actual) {
		super(String.format("Bad Notification type. Expected %s, actual %s", expected, actual));
	}

}