package com.trius.businessman.dao.basedata;

import com.trius.businessman.dao.entity.Contact;
import com.trius.businessman.dao.repository.ContactRepository;
import com.trius.businessman.dao.repository.ContactTypeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class ContactTest {

    @Autowired
    ContactRepository contactRepository;
    @Autowired
    ContactTypeRepository contactTypeRepository;

    @Test
    public  void addContact(){

        Contact contact = Contact.builder()
                .contactInfo("12312312")
                .contactType(contactTypeRepository.findByContactTypeId(2))
                .build();

        contactRepository.save(contact);
    }

}
