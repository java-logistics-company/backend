package com.cscb025.logistic.company.controller;

import com.cscb025.logistic.company.controller.request.EmployeeRegistrationRequestDTO;
import com.cscb025.logistic.company.controller.request.UserLoginRequestDTO;
import com.cscb025.logistic.company.controller.response.UserRegistrationResponseDTO;
import com.cscb025.logistic.company.exception.TokenExpiredException;
import com.cscb025.logistic.company.service.ClientService;
import com.cscb025.logistic.company.service.EmployeeService;
import com.cscb025.logistic.company.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "*")
public class UserController {

    private final EmployeeService employeeService;
    private final ClientService clientService;
    private final UserService userService;

    @Autowired
    public UserController(EmployeeService employeeService, ClientService clientService, UserService userService) {
        this.employeeService = employeeService;
        this.clientService = clientService;
        this.userService = userService;
    }

    @PostMapping("/employee")
    public ResponseEntity<UserRegistrationResponseDTO> registerEmployee(@RequestBody @Valid EmployeeRegistrationRequestDTO user) {
        return ResponseEntity.ok(employeeService.register(user));
    }

    @PostMapping("/login")
    public ResponseEntity<UserRegistrationResponseDTO> login(@RequestBody @Valid UserLoginRequestDTO loginRequest) throws TokenExpiredException {
        return ResponseEntity.ok(userService.getUserLoginResponse(loginRequest));
    }

}
