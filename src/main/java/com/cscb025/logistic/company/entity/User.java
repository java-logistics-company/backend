package com.cscb025.logistic.company.entity;

import com.cscb025.logistic.company.enums.UserRole;
import lombok.Data;

@Data
public abstract class User {
    private String uid;
    private String email;
    private String password;
    private UserRole userRole;
}
