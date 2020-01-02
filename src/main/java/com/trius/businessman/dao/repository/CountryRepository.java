package com.trius.businessman.dao.repository;

import com.trius.businessman.dao.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, Integer> {
    Country findByCountryId(Integer countryId);
    Country findByCountryName(String countryName);

}
