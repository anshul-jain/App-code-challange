package com.techsmart.billapp.model;

public class SuccessResponse extends Response {

    public String accountIdentifier;

    public SuccessResponse() {
        this.success = true;
    }

    public SuccessResponse(String accountIdentifier) {
        this();
        this.accountIdentifier = accountIdentifier;
    }
}