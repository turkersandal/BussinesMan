package com.trius.businessman.dao.basedata;

import com.trius.businessman.dao.entity.ContractState;
import com.trius.businessman.dao.repository.ContractStateRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ContractStateTest {

    @Autowired
    private ContractStateRepository contractStateRepository;

    @Test
    public void saveContractState(){
        Set<ContractState> contractStateSet = new LinkedHashSet<>(
                Arrays.asList(
                    ContractState.builder().contractState("Aktif").build(),
                    ContractState.builder().contractState("Pasif").build()
                )
        );
        contractStateRepository.saveAll(contractStateSet);
    }

}
