package com.trius.businessman.rest;


import com.trius.businessman.dao.dto.PersonAddressDTO;
import com.trius.businessman.dao.dto.PersonContactDTO;
import com.trius.businessman.dao.dto.PersonDTO;
import com.trius.businessman.dao.entity.Person;
import com.trius.businessman.dao.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;



@RestController
@RequestMapping("/api/person")
public class PersonRestController {


    @Autowired
    PersonService personService;


    @RequestMapping(value = "/{person_id}", method = RequestMethod.GET)
    public  ResponseEntity<?>  getPerson(@PathVariable("person_id") Integer id) {

    try {

             return new ResponseEntity<PersonDTO>(personService.convertPersonToDTO(personService.findByPersonId(id)), HttpStatus.OK);

        }catch (Exception e){

            return new ResponseEntity<String>(HttpStatus.NOT_FOUND.toString(), HttpStatus.NOT_FOUND);
        }

    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<Person> getAll() {

        return personService.findAll();
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ResponseEntity<PersonDTO> createPerson(@RequestBody PersonDTO personDTO) {

        return new ResponseEntity<PersonDTO>(personService.convertPersonToDTO(personService.save(personService.convertPersonDTOToEntity(personDTO))), HttpStatus.CREATED);
    }

    @RequestMapping(value = "/update/{person_id}",method = RequestMethod.PUT)
    public ResponseEntity<?> updatePerson(@RequestBody PersonDTO personDTO,@PathVariable("person_id") Integer person_id){

        if(personDTO.getPersonId() != null){

                if(personDTO.getPersonId() == person_id) {

                    return new ResponseEntity<PersonDTO>(personService.convertPersonToDTO(personService.save(personService.convertPersonDTOToEntity(personDTO))), HttpStatus.OK);

                }else{

                    return new ResponseEntity<String>("Lütfen güncellenecek kişiye ait id'yi giriniz...",HttpStatus.BAD_REQUEST);

                }
        }else {

            return new ResponseEntity<String>("Lütfen id alanını boş bırakmayınız...",HttpStatus.BAD_REQUEST);

        }


    }

    @RequestMapping(value = "/addAddress", method = RequestMethod.POST)
    public ResponseEntity<PersonAddressDTO> addAddress(@RequestBody PersonAddressDTO personAddressDTO) {

        return new ResponseEntity<PersonAddressDTO>(personService.addPersonAddress(personAddressDTO), HttpStatus.CREATED);
    }

    @RequestMapping(value = "/addContact", method = RequestMethod.POST)
    public ResponseEntity<PersonContactDTO> addContact(@RequestBody PersonContactDTO personContactDTO) {

        return new ResponseEntity<PersonContactDTO>(personService.addPersonContact(personContactDTO), HttpStatus.CREATED);
    }

    @RequestMapping(value = "/delete/{person_id}", method = RequestMethod.DELETE)
    public String deletePerson(@PathVariable("person_id") Integer person_id) {

        try {
            personService.deletePerson(person_id);
            return person_id.toString() + " ID'li Kişi Başarıyla silindi";
        } catch (Exception e) {

           return e.getMessage();
        }


    }

    @RequestMapping(value = "deleteAddress/{person_id}/{address_id}",method = RequestMethod.DELETE)
    public String deleteAddress(@PathVariable("person_id") Integer person_id,@PathVariable("address_id") Integer address_id ){


        try {

            personService.deleteAddress(person_id,address_id);
            return  person_id +" ID'li kullanıcının " + address_id + " ID'li adresi başarıyla silindi...";

        }catch (Exception e){

            return  person_id + " ID'li kullanıcıya ait "+ address_id+" ID'li addres bulunamadı.";
        }





    }

    @RequestMapping(value = "deleteContact/{person_id}/{contact_id}",method = RequestMethod.DELETE)
    public  String deleteContact(@PathVariable("person_id") Integer person_id,@PathVariable("contact_id") Integer contact_id){

        try {

            personService.deleteContact(person_id,contact_id);
            return  person_id +" ID'li kullanıcının " + contact_id + " ID'li kontağı başarıyla silindi...";

        }catch (Exception e){

            return  person_id + " ID'li kullanıcıya ait "+ contact_id+" ID'li kontak bulunamadı.";
        }
    }

}






