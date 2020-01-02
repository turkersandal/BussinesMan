package com.trius.businessman.dao.repository;

import com.trius.businessman.dao.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PersonRepository extends JpaRepository<Person, Integer> {
    Person findByPersonId(Integer personId);
    Person findByPersonName(String personName);
    Person deleteByPersonId(Integer personId);
    List<Person> findAll();

}
