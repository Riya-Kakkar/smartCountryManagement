package com.smartCountryManagement.Controller;

import com.smartCountryManagement.Entities.Country;
import com.smartCountryManagement.Entities.State;
import com.smartCountryManagement.Services.CountryService;
import com.smartCountryManagement.Services.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/states")
public class StateController {

    @Autowired
    private StateService stateService;
    @Autowired
    private CountryService countryService;

    @GetMapping("/show-states")
    public  String showStates(Model model){
        model.addAttribute("title" , "SHOW - Smart Country Management");
        model.addAttribute("states", stateService.getAllStates());
        model.addAttribute("countries", countryService.getAllCountries());
        model.addAttribute("newState", new State());
        return "State/show_states";
    }

    @PostMapping("/add-states")
    public String addStates(@ModelAttribute("newState") State states , Model model){
        model.addAttribute("title" , "SHOW - Smart Country Management");
        stateService.saveState(states);
        return "redirect:/show-states";
    }

    @GetMapping("/delete-states/{id}")
    public String deleteStates(@PathVariable int id, Model model){
        model.addAttribute("title" , "SHOW - Smart Country Management");
        stateService.deleteState(id);
        return "redirect:/show-states";
    }

}
