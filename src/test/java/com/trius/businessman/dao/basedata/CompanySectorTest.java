package com.trius.businessman.dao.basedata;

import com.trius.businessman.dao.entity.CompanySector;
import com.trius.businessman.dao.repository.CompanySectorRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

@SpringBootTest
public class CompanySectorTest {

    @Autowired
    private CompanySectorRepository companySectorRepository;

    @Test
    public void saveCompanySector(){
        Set<CompanySector> companySectorSet = new LinkedHashSet<>(
                Arrays.asList(
                        CompanySector.builder().companySectorName("Bilgi Teknolojileri").build(),
                        CompanySector.builder().companySectorName("Retail ve Loyalty").build()
                )
        );

        companySectorRepository.saveAll(companySectorSet);
    }

}
