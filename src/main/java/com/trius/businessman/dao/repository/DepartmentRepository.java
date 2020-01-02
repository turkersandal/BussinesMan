package com.trius.businessman.dao.repository;

import com.trius.businessman.dao.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department,Integer> {
    Department findByDepartmentName(String departmentName);
    Department findByDepartmentId(Integer departmentId);
}
