package com.smartCountryManagement.DaoRepo;

import com.smartCountryManagement.Entities.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends JpaRepository<Country,Integer> {


}
