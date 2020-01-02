package com.trius.businessman.rest;

import com.trius.businessman.dao.dto.AddressDTO;
import com.trius.businessman.dao.dto.PersonAddressDTO;
import com.trius.businessman.dao.dto.PersonContactDTO;
import com.trius.businessman.dao.dto.PersonDTO;
import com.trius.businessman.dao.entity.Person;
import com.trius.businessman.dao.repository.AddressRepository;
import com.trius.businessman.dao.service.PersonService;
import org.omg.Messaging.SYNC_WITH_TRANSPORT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.*;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
@RestController
@RequestMapping("/api/person")
public class PersonRestController {


    @Autowired
    PersonService personService;


    @RequestMapping(value = "/{person_id}", method = RequestMethod.GET)
    public ResponseEntity<PersonDTO> getPerson(@PathVariable("person_id") Integer id) {


            return new ResponseEntity<PersonDTO>(personService.convertPersonToDTO(personService.findByPersonId(id)), HttpStatus.OK);

    }

    @RequestMapping(value = "/all",method = RequestMethod.GET)
    public List<Person> getAll(){

        return personService.findAll();
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ResponseEntity<PersonDTO> createPerson(@RequestBody PersonDTO personDTO) {

        return new ResponseEntity<PersonDTO>(personService.convertPersonToDTO(personService.save(personService.convertPersonDTOToEntity(personDTO))), HttpStatus.CREATED);
    }

    /*    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public ResponseEntity<PersonDTO> deletePerson(@RequestBody PersonDTO personDTO) {

        return new ResponseEntity<PersonDTO>(personService.convertPersonToDTO(personService.deleteByPersonId(personService.convertPersonDTOToEntity(personDTO))), HttpStatus.CREATED);
    }*/

    @RequestMapping(value = "/addAddress", method = RequestMethod.POST)
    public ResponseEntity<PersonAddressDTO> addAddress(@RequestBody PersonAddressDTO personAddressDTO) {

        return new ResponseEntity<PersonAddressDTO>(personService.addPersonAddress(personAddressDTO), HttpStatus.CREATED);
    }



    @RequestMapping(value = "/addContact", method = RequestMethod.POST)
    public ResponseEntity<PersonContactDTO> addContact(@RequestBody PersonContactDTO personContactDTO) {

        return new ResponseEntity<PersonContactDTO>(personService.addPersonContact(personContactDTO), HttpStatus.CREATED);
    }


    @RequestMapping (value = "/delete/{person_id}",method = RequestMethod.DELETE)
    public Person deletePerson(@PathVariable("person_id") Integer person_id){

      return   personService.deleteByPersonId(person_id);

    }

    // Delete Person
    // Delete Address
    // Delete Contact


}
