package com.trius.businessman.dao.repository;

import com.trius.businessman.dao.entity.MaritalStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MaritalStatusRepository extends JpaRepository<MaritalStatus, Integer> {
    MaritalStatus findByMaritalStatusName(String maritalStatusName);
    MaritalStatus findByMaritalStatusId(Integer maritalStatusId);

}
