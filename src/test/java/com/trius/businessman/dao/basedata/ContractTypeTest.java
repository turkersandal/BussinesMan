package com.trius.businessman.dao.basedata;

import com.trius.businessman.dao.entity.ContractType;
import com.trius.businessman.dao.repository.ContractTypeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ContractTypeTest {

    @Autowired
    private ContractTypeRepository contractTypeRepository;

    @Test
    public void saveContractType(){
        Set<ContractType> contractTypeSet = new LinkedHashSet<>(
                Arrays.asList(
                    ContractType.builder().contractTypeName("Personel").build(),
                    ContractType.builder().contractTypeName("Kurum").build(),
                    ContractType.builder().contractTypeName("Danışman").build()
                )
        );
        contractTypeRepository.saveAll(contractTypeSet);
    }
}
