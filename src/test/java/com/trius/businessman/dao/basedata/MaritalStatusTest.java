package com.trius.businessman.dao.basedata;

import com.trius.businessman.dao.entity.MaritalStatus;
import com.trius.businessman.dao.repository.MaritalStatusRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

@SpringBootTest
public class MaritalStatusTest {

    @Autowired
    private MaritalStatusRepository maritalStatusRepository;

    @Test
    public void saveMaritalStatus() {
        Set<MaritalStatus> maritalStatusSet = new LinkedHashSet<>(
                Arrays.asList(
                        MaritalStatus.builder().maritalStatusName("Evli").build(),
                        MaritalStatus.builder().maritalStatusName("Bekar").build()
                )
        );

        maritalStatusRepository.saveAll(maritalStatusSet);
    }


}
