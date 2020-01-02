package com.trius.businessman.dao.service.impl;

import com.trius.businessman.dao.entity.Company;
import com.trius.businessman.dao.repository.CompanyRepository;
import com.trius.businessman.dao.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompanyServiceImp implements CompanyService {

    @Autowired
    CompanyRepository companyRepository;


    public void save(Company company){
        companyRepository.save(company);

    }

    public void delete(Company company){
        companyRepository.delete(company);
    }
    public  void getCompany(Company company){
        companyRepository.findByCompanyId(company.getCompanyId());
    }




}
