package com.smartCountryManagement.DaoRepo;

import com.smartCountryManagement.Entities.State;
import org.springframework.data.jpa.repository.JpaRepository;



public interface StateRepository extends JpaRepository<State,Integer> {
}
