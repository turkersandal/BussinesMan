package com.trius.businessman.dao.repository;

import com.trius.businessman.dao.entity.CompanySector;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanySectorRepository extends JpaRepository<CompanySector,Integer> {

    CompanySector findByCompanySectorId(Integer companySectorId);
    CompanySector findByCompanySectorName(String companySectorName);





}
