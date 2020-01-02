package com.trius.businessman.dao.repository;

import com.trius.businessman.dao.entity.AssuranceType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AssuranceTypeRepository extends JpaRepository<AssuranceType,Integer> {
    AssuranceType findByAssuranceTypeName(String assuranceTypeName);
    AssuranceType findByAssuranceTypeId(Integer assuranceTypeId);
}
