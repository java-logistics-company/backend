package com.cscb025.logistic.company.controller;

import com.cscb025.logistic.company.controller.request.EmployeeRegistrationRequestDTO;
import com.cscb025.logistic.company.controller.response.UserRegistrationResponseDTO;
import com.cscb025.logistic.company.enums.UserRole;
import com.cscb025.logistic.company.service.ClientService;
import com.cscb025.logistic.company.service.EmployeeService;
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

    @Autowired
    public UserController(EmployeeService employeeService, ClientService clientService) {
        this.employeeService = employeeService;
        this.clientService = clientService;
    }

    @PostMapping("/employee")
    public ResponseEntity<UserRegistrationResponseDTO> registerEmployee(@RequestBody @Valid EmployeeRegistrationRequestDTO user) {
        return ResponseEntity.ok(employeeService.register(user));
    }

}
