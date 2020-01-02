package com.trius.businessman.dao.basedata;

import com.trius.businessman.dao.entity.Department;
import com.trius.businessman.dao.repository.DepartmentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class DepartmentTest {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Test
    public void saveDepartment(){

        Set<Department> departmentSet = new LinkedHashSet<>(
                Arrays.asList(
                    Department.builder().departmentName("İnsan Kaynakları").build(),
                    Department.builder().departmentName("Yazılım Geliştirme").build(),
                    Department.builder().departmentName("CEO").build()
            )
        );
        departmentRepository.saveAll(departmentSet);
    }
}
