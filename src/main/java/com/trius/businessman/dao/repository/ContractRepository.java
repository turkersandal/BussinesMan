package com.trius.businessman.dao.repository;

import com.trius.businessman.dao.entity.Contract;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContractRepository extends JpaRepository<Contract, Integer> {
    Contract findByContractId(Integer contractId);
}
