package com.smartCountryManagement.DaoRepo;

import com.smartCountryManagement.Entities.Country;
import com.smartCountryManagement.Entities.State;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StateRepository extends JpaRepository<State,Integer> {
    List<State> findByCountry(Country country);
}
