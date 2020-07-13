package com.cscb025.logistic.company.controller.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRegistrationResponseDTO {

    private String token;

    private UserLoginResponseDTO userLoginResponse;

//    private EmployeeRole employeeRole;
}
