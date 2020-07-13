package com.cscb025.logistic.company.enums;

public enum UserRole {
    ADMIN("Admin"), EMPLOYEE("Employee"), CLIENT("Client");

    private String name;

    UserRole(String name) {
        this.name = name;
    }
}
