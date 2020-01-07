package com.trius.businessman.dao.service;

import com.trius.businessman.dao.dto.PersonAddressDTO;
import com.trius.businessman.dao.dto.PersonContactDTO;
import com.trius.businessman.dao.dto.PersonDTO;
import com.trius.businessman.dao.dto.PersonDetailDTO;
import com.trius.businessman.dao.entity.Address;
import com.trius.businessman.dao.entity.Person;

import java.util.List;


public interface PersonService {

    List<Person> findAll();
    Person findByPersonId(Integer id);

    Person save(Person person);
    Person update(Person person);

    Person convertPersonDTOToEntity(PersonDTO personDTO);
    PersonDTO convertPersonToDTO(Person person);

    PersonAddressDTO addPersonAddress(PersonAddressDTO personAddressDTO);
    PersonContactDTO addPersonContact(PersonContactDTO personContactDTO);

    void deletePerson(Integer id);
    void deleteAddress(Integer person_id,Integer address_id);
    void deleteContact(Integer person_id,Integer contact_id);









}
