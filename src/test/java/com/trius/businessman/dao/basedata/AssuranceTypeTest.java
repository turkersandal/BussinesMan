package com.trius.businessman.dao.basedata;

import com.trius.businessman.dao.entity.AssuranceType;
import com.trius.businessman.dao.repository.AssuranceTypeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.*;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AssuranceTypeTest {

    @Autowired
    private AssuranceTypeRepository assuranceTypeRepository;

    @Test
    public void saveAssuranceType(){
        Set<AssuranceType> assuranceTypeSet = new LinkedHashSet<>(
                Arrays.asList(
                    AssuranceType.builder().assuranceTypeName("Sgk").build(),
                    AssuranceType.builder().assuranceTypeName("Bağkur").build()
                )
        );

        assuranceTypeRepository.saveAll(assuranceTypeSet);
    }
}
