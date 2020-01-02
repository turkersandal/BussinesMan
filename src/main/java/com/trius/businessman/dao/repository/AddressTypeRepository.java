package com.trius.businessman.dao.repository;

import com.trius.businessman.dao.entity.AddressType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressTypeRepository extends JpaRepository<AddressType, Integer> {
    AddressType findByAddressTypeName(String addressTypeName);
    AddressType findByAddressTypeId(Integer addressTypeId);
}
