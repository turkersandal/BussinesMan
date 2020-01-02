package com.trius.businessman.dao.repository;

import com.trius.businessman.dao.entity.ContractState;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContractStateRepository extends JpaRepository<ContractState, Integer> {

    ContractState findByContractStateId(Integer contractStateId);
    ContractState findByContractState(String contractState);
}
