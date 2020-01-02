package com.trius.businessman.dao.service;

import com.trius.businessman.dao.entity.Company;

public interface CompanyService {

    void save(Company company);

    void delete(Company company);

    void getCompany(Company company);
}
