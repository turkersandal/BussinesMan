package com.trius.businessman.dao.repository;

import com.trius.businessman.dao.entity.Staff;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StaffRepository extends JpaRepository<Staff, Integer> {
    Staff findByStaffId(Integer staffId);
}
