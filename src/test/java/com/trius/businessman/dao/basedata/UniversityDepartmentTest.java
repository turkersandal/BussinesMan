package com.trius.businessman.dao.basedata;

import com.trius.businessman.dao.entity.UniversityDepartment;
import com.trius.businessman.dao.repository.UniversityDepartmentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

@SpringBootTest
public class UniversityDepartmentTest {

    @Autowired
    private UniversityDepartmentRepository universityDepartmentRepository;

    @Test
    public void saveUniversityDepartment(){
        Set<UniversityDepartment> universityDepartmentSet = new LinkedHashSet<>(
                Arrays.asList(
                        UniversityDepartment.builder().universityDepartmentName("Bilgisayar Mühendisliği").build(),
                        UniversityDepartment.builder().universityDepartmentName("Yazılım Mühendisliği").build()
                )
        );

        universityDepartmentRepository.saveAll(universityDepartmentSet);
    }

}
