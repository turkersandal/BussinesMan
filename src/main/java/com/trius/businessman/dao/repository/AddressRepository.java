package com.trius.businessman.dao.repository;

import com.trius.businessman.dao.entity.Address;
import com.trius.businessman.dao.entity.District;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address,Integer> {

    Address findByDistrict(District district);
    Address findByAddressId(Integer id);


    /*@Transactional
    void deleteByAddressId(Integer addressId);*/
}
