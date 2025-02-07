package com.smartCountryManagement.Controller;

import com.smartCountryManagement.DaoRepo.CountryRepository;
import com.smartCountryManagement.DaoRepo.StateRepository;
import com.smartCountryManagement.Entities.Country;
import com.smartCountryManagement.Entities.State;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
public class CountryStateController {

   @Autowired
    private CountryRepository countryRepository;
   @Autowired
    private StateRepository stateRepository;

   @GetMapping("/")
   public String home(Model model){
       model.addAttribute("countries", countryRepository.findAll());
       model.addAttribute("states", stateRepository.findAll());
      return "index";
   }

    @GetMapping("/country/add")
    public  String showAddCountryForm(Model model){
        model.addAttribute("country", new Country());
        return "country_form";
    }

    @PostMapping("/country/save")
    public String saveCountry(@Valid @ModelAttribute("country") Country country , BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "country_form";
        }
        countryRepository.save(country);
        return "redirect:/";
    }

    @GetMapping("/country/edit/{id}")
    public String showEditCountryForm(@PathVariable int id , Model model ){
     Country country = countryRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid Country Id:" +id));
      model.addAttribute("country" , country);
        return "country_form";
    }

    @GetMapping("/country/delete/{id}")
    public String deleteCountry(@PathVariable("id") int id ){

        Country country = countryRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid Country Id:" +id));
        countryRepository.delete(country);
        return "redirect:/";
    }

    @GetMapping("/state/add")
    public  String showAddStateForm(Model model){
       model.addAttribute("state" , new State());
        model.addAttribute("countries", countryRepository.findAll());
        return "state_form";
    }

    @PostMapping("/state/save")
    public String saveState(@Valid @ModelAttribute("state") State state , BindingResult result,@RequestParam("country") int countryId , Model model) {
        if (result.hasErrors()) {
            model.addAttribute("countries" , countryRepository.findAll());
            return "state_form";
        }
        Country country = countryRepository.findById(countryId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid Country ID: " + countryId));
        state.setCountry(country);
        stateRepository.save(state);
        return "redirect:/";
    }

    @GetMapping("/state/edit/{id}")
    public String showEditStateForm(@PathVariable int id , Model model ){
        State state = stateRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid state Id:" +id));
        model.addAttribute("state" , state );
        model.addAttribute("countries" , countryRepository.findAll());
        return "state_form";
    }

    @GetMapping("/state/delete/{id}")
    public String deleteState(@PathVariable("id") int id ){
        State state = stateRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid state Id:" +id));
        stateRepository.delete(state);
        return "redirect:/";
    }

}
