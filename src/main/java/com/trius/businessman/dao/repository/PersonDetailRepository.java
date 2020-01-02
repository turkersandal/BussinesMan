package com.trius.businessman.dao.repository;

import com.trius.businessman.dao.entity.PersonDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonDetailRepository extends JpaRepository<PersonDetail, Integer> {
}
