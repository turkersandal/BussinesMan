package com.trius.businessman.dao.basedata;

import com.trius.businessman.dao.entity.AssuranceType;
import com.trius.businessman.dao.entity.Department;
import com.trius.businessman.dao.entity.Staff;
import com.trius.businessman.dao.repository.AssuranceTypeRepository;
import com.trius.businessman.dao.repository.DepartmentRepository;
import com.trius.businessman.dao.repository.StaffRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class StaffTest {

     @Autowired
    StaffRepository staffRepository;
     @Autowired
    DepartmentRepository departmentRepository;
     @Autowired
    AssuranceTypeRepository assuranceTypeRepository;

       @Test
        public void  add(){
           Department department=departmentRepository.findByDepartmentId(1);
           AssuranceType assuranceType=assuranceTypeRepository.findByAssuranceTypeId(1);
           staffRepository.save(Staff.builder().staffSalary("100000TL").department(department).assuranceType(assuranceType).build());
       }
}
