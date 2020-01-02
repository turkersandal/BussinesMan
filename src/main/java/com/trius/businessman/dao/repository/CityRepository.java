package com.trius.businessman.dao.repository;

import com.trius.businessman.dao.entity.City;
import com.trius.businessman.dao.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CityRepository extends JpaRepository<City,Integer> {

    City findByCityId(Integer cityId);
    City findByCityName(String cityName);
    List<City> findAllByCountry(Country country);

 }
