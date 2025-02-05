package com.smartCountryManagement.Services;

import com.smartCountryManagement.DaoRepo.StateRepository;
import com.smartCountryManagement.Entities.Country;
import com.smartCountryManagement.Entities.State;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StateService {
    @Autowired
    private StateRepository stateRepository;

    public List<State> getAllStates(){
        return stateRepository.findAll();
    }

    public  void  saveState(State state){
        stateRepository.save(state);
    }

    public  void  deleteState(int id){
        stateRepository.deleteById(id);
    }
}
