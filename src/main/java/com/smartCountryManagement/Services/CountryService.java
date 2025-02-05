package com.smartCountryManagement.Services;

import com.smartCountryManagement.DaoRepo.CountryRepository;
import com.smartCountryManagement.Entities.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryService {

    @Autowired
    private CountryRepository countryRepository;

    public List<Country> getAllCountries(){
        return countryRepository.findAll();
    }

    public  void  saveCountry(Country country){
        countryRepository.save(country);
    }

    public  void  deleteCountry(int id){
        countryRepository.deleteById(id);
    }
}
