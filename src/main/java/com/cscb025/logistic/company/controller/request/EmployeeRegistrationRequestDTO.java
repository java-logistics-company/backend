package com.cscb025.logistic.company.controller.request;

import com.cscb025.logistic.company.enums.EmployeeRole;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
public class EmployeeRegistrationRequestDTO {

    @NotBlank(message = "Invalid employee role!")
    private String employeeRole;

    @NotBlank(message = "Email must not be empty!")
    @Pattern(regexp = ".+@.+\\.[a-z]+", message = "Invalid email address format!")
    private String email;

    @NotBlank(message = "Name must not be empty!")
    private String name;

    @NotBlank(message = "Password must not be empty!")
    @Size(min = 6, message = "Length must be at least 6 symbols!")
    private String password;

    @NotBlank(message = "Password must not be empty!")
    @Size(min = 6, message = "Length must be at least 6 symbols!")
    private String repeatPassword;

    @NotBlank(message = "Office must not be empty!")
    private String officeId;

//    @Pattern(regexp = "(\\+)?(359|0)8[789]\\d{1}\\d{3}\\d{3}", message = "Invalid phone number format!")
//    private String phone;
}
