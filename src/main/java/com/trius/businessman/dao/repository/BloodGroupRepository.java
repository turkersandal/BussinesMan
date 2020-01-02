package com.trius.businessman.dao.repository;

import com.trius.businessman.dao.entity.BloodGroup;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BloodGroupRepository extends JpaRepository<BloodGroup, Integer> {
    BloodGroup findByBloodGroupName(String bloodGroupName);
    BloodGroup findByBloodGroupId(Integer bloodGroupId);

}
