package com.trius.businessman.dao.repository;

import com.trius.businessman.dao.entity.Gender;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenderRepository extends JpaRepository<Gender,Integer> {
    Gender findByGenderId(Integer genderId);
    Gender findByGenderName(String genderName);
}
