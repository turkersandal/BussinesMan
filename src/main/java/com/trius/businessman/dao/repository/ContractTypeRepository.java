package com.trius.businessman.dao.repository;

import com.trius.businessman.dao.entity.ContractType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContractTypeRepository extends JpaRepository<ContractType, Integer> {
    ContractType findByContractTypeName(String contractTypeName);
    ContractType findByContractTypeId(Integer contractTypeId);
}
