package com.cscb025.logistic.company.service;

import com.cscb025.logistic.company.entity.Client;
import com.cscb025.logistic.company.entity.Employee;
import com.cscb025.logistic.company.entity.User;
import com.cscb025.logistic.company.repository.ClientRepository;
import com.cscb025.logistic.company.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private static final String USER_NOT_FOUND = "User not found!";
    private final ClientRepository clientRepository;
    private final EmployeeRepository employeeRepository;

    @Autowired
    public UserService(ClientRepository clientRepository, EmployeeRepository employeeRepository) {
        this.clientRepository = clientRepository;
        this.employeeRepository = employeeRepository;
    }

    public User findByEmail(String email) {
        User user = null;
        Optional<Employee> employeeOptional = employeeRepository.findByEmail(email);
        if (employeeOptional.isPresent()) {
            Employee employee = employeeOptional.get();
            user = employee;
            user.setUid(employee.getUid());
            user.setEmail(employee.getEmail());
            user.setPassword(employee.getPassword());
        } else {
            Optional<Client> clientOptional = clientRepository.findByEmail(email);
            if (clientOptional.isPresent()) {
                Client client = clientOptional.get();
                user = client;
                user.setUid(client.getUid());
                user.setEmail(client.getEmail());
                user.setPassword(client.getPassword());
            } else {
                throw new BadCredentialsException("Wrong credentials");
            }
        }
        return user;
    }
}
