package com.trius.businessman.dao.repository;

import com.trius.businessman.dao.entity.City;
import com.trius.businessman.dao.entity.District;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DistrictRepository extends JpaRepository<District,Integer> {

    District findByDistrictId(Integer districtId);
    List<District> findByCity(City city);
    District findByDistrictName(String districtName);
}
