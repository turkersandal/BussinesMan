package com.trius.businessman.dao.repository;

import com.trius.businessman.dao.entity.UniversityDepartment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UniversityDepartmentRepository extends JpaRepository<UniversityDepartment, Integer> {
    UniversityDepartment findByUniversityDepartmentId(Integer universityDepartmentId);
    UniversityDepartment findByUniversityDepartmentName(String universityDepartmentName);

}
