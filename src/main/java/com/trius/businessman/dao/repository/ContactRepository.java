package com.trius.businessman.dao.repository;

import com.trius.businessman.dao.entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<Contact, Integer> {
    Contact findByContactId(Integer contactId);
}
