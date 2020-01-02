package com.trius.businessman.dao.repository;

import com.trius.businessman.dao.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, Integer> {
    Company findByCompanyId(Integer companyId);
    Company findByCompanyName(String companyName);
}
