package com.cscb025.logistic.company.util;

import com.cscb025.logistic.company.entity.Company;
import com.cscb025.logistic.company.repository.CompanyRepository;
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

    @Autowired
    public BasicInserts(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @PostConstruct
    public void basicInserts(){
        Company nbu = new Company(NBU_LOGISTICS);
        nbu = saveCompany(nbu);

    }

    private Company saveCompany(Company company){
        Optional<Company> company1 = companyRepository.findByName(company.getName());
        if(!company1.isPresent()){
            company = companyRepository.save(company);
            return company;
        }
        return company1.get();
    }
}
