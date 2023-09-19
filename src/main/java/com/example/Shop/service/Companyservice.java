package com.example.Shop.service;

import com.example.Shop.exception.CompanyAlreadyExistException;
import com.example.Shop.model.Company;
import com.example.Shop.repository.Companyrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class Companyservice {

    @Autowired
    Companyrepository companyrepository;

    public String addcompany(String name) {
        Optional<Company> optionalCompany = companyrepository.findbyname(name);
        if(optionalCompany.isPresent()){
            throw  new CompanyAlreadyExistException("already exist");
        }
        Company company = new Company();
        company.setCompanyname(name);
        companyrepository.save(company);
        return "Successfull";
    }
}
