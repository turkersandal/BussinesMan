package com.trius.businessman.dao.repository;

import com.trius.businessman.dao.entity.PersonIdentity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonIdentityRepository extends JpaRepository<PersonIdentity, Integer> {

}
