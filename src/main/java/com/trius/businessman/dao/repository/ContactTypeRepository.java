package com.trius.businessman.dao.repository;

import com.trius.businessman.dao.entity.ContactType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactTypeRepository extends JpaRepository<ContactType, Integer> {
    ContactType findByContactTypeName(String contactTypeName);
    ContactType findByContactTypeId(Integer contactTypeId);


}
