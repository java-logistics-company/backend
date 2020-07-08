package com.cscb025.logistic.company.service;

import com.cscb025.logistic.company.controller.request.EmployeeRegistrationRequestDTO;
import com.cscb025.logistic.company.controller.response.UserRegistrationResponseDTO;
import org.springframework.stereotype.Service;

@Service
public class ClientService {
    public UserRegistrationResponseDTO registerClient(EmployeeRegistrationRequestDTO user) {
        return new UserRegistrationResponseDTO();
    }
}
