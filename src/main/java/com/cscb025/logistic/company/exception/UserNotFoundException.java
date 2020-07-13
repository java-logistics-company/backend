package com.cscb025.logistic.company.exception;

public class UserNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 8299010620642337631L;

    public UserNotFoundException(String message) {
        super(message);
    }
}
