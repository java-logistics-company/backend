package com.cscb025.logistic.company.util;

import com.cscb025.logistic.company.entity.Company;
import com.cscb025.logistic.company.entity.Employee;
import com.cscb025.logistic.company.enums.Role;
import com.cscb025.logistic.company.repository.CompanyRepository;
import com.cscb025.logistic.company.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Optional;

@ConditionalOnProperty(value = "basic.inserts.enable", havingValue = "true")
@Component
public class BasicInserts {

    private static final String NBU_LOGISTICS = "NBU Logistics";

    private final CompanyRepository companyRepository;
    private final EmployeeRepository employeeRepository;


    @Autowired
    public BasicInserts(CompanyRepository companyRepository, EmployeeRepository employeeRepository) {
        this.companyRepository = companyRepository;
        this.employeeRepository = employeeRepository;
    }

    @PostConstruct
    public void basicInserts() {
        Company nbu = new Company(NBU_LOGISTICS);
        nbu = saveCompany(nbu);
        Employee admin = new Employee("admin@nbu.bg", "password", Role.ADMIN);
        admin = saveEmployee(admin);

    }

    private Company saveCompany(Company company) {
        Optional<Company> company1 = companyRepository.findByName(company.getName());
        if (!company1.isPresent()) {
            company = companyRepository.save(company);
            return company;
        }
        return company1.get();
    }

    private Employee saveEmployee(Employee employee) {
        Optional<Employee> employeeOptional = employeeRepository.findByEmail(employee.getEmail());
        if (!employeeOptional.isPresent()) {
            employee = employeeRepository.save(employee);
            return employee;
        }
        return employeeOptional.get();
    }
}
