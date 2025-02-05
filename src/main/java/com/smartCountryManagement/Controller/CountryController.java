package com.smartCountryManagement.Controller;

import com.smartCountryManagement.Entities.Country;
import com.smartCountryManagement.Services.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/countries")
public class CountryController {

    @Autowired
    private CountryService countryService;

    @GetMapping("/show-countries")
    public  String showCountries(Model model){
        model.addAttribute("title" , "SHOW - Smart Country Management");
        model.addAttribute("countries", countryService.getAllCountries());
        model.addAttribute("newCountry", new Country());
        return "Country/show_country";
    }

    @PostMapping("/add-countries")
    public String addCountry(@ModelAttribute("newCountry") Country country ,Model model){
        model.addAttribute("title" , "ADD - Smart Country Management");
        countryService.saveCountry(country);
        return "redirect:/show-countries";
    }

    @GetMapping("/delete-country/{id}")
    public String deleteCountry(@PathVariable int id , Model model ){
        model.addAttribute("title" , "DELETE - Smart Country Management");
        countryService.deleteCountry(id);
        return "redirect:/show-countries";
    }

}
