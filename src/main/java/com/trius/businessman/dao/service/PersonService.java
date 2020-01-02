package com.trius.businessman.dao.service;

import com.trius.businessman.dao.dto.PersonAddressDTO;
import com.trius.businessman.dao.dto.PersonContactDTO;
import com.trius.businessman.dao.dto.PersonDTO;
import com.trius.businessman.dao.entity.Address;
import com.trius.businessman.dao.entity.Person;

import java.util.List;


public interface PersonService {

    Person save(Person person);

    Person deleteByPersonId(Integer id);

    Person findByPersonId(Integer id);

    List<Person> findAll();

    Person convertPersonDTOToEntity(PersonDTO personDTO);

    PersonDTO convertPersonToDTO(Person person);

    PersonAddressDTO addPersonAddress(PersonAddressDTO personAddressDTO);

    PersonContactDTO addPersonContact(PersonContactDTO personContactDTO);









}
