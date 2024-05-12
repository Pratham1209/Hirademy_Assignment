package com.Assistants.serviceimpl;

import com.Assistants.entity.Assistants;
import com.Assistants.Exceptions.ResourceNotFoundException;
//import com.Assistants.repository.AssistantsRepository;
import com.Assistants.repository.*;
import com.Assistants.services.AssistantsServices;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class AssistantsServiceImpl implements AssistantsServices {

    @Autowired
    private AssistantsRepository assistantsRepository;
    
    //to create new assistant entry
    @Override
    public String create(Assistants assistant) {
        String Id = UUID.randomUUID().toString();
        assistant.setId(Id);


        Date current_Date = new Date();

        assistant.setJoiningDate(current_Date);
        assistant.setLastActivity(current_Date);
        assistantsRepository.save(assistant);

        return Id;
    }

    //to get all the assistants list
    @Override
    public List<Assistants> getAssistants() {
        return assistantsRepository.findAll();
    }

    //to get a single assistant using id
    @Override
    public Assistants getAssistant(String id) {

        // Getting Assistant from ASSISTANT SERVICE
            Assistants account = assistantsRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Assistant with given id not found try again with correct details !!"));

            return account;
    }

    //to update assistant details
    @Override
    public Assistants updateAssistant(String id, Assistants assistant) {

    	Assistants newAssistant = assistantsRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Assistant with given id not found  try again with correct details!!"));
    	newAssistant.setCity(assistant.getCity());
    	newAssistant.setCountry(assistant.getCountry());
    	newAssistant.setDepartment(assistant.getDepartment());
    	newAssistant.setEmail(assistant.getEmail());
    	newAssistant.setMobile(assistant.getMobile());
    	newAssistant.setName(assistant.getName());
    	newAssistant.setRole(assistant.getRole());
    	newAssistant.setSalary(assistant.getSalary());
    	
    	newAssistant.setLastActivity(new Date());
    	
        return assistantsRepository.save(newAssistant);
    }
    
    //to delete assistant entry using id
    @Override
    public void deleteAssistantUsingId(String Id) {
    	Assistants newAssistant = assistantsRepository.findById(Id).orElseThrow(() -> new ResourceNotFoundException("Assistant with given id not found  try again with correct details!!"));
    	
//        optionalAssistant.ifPresent(assistant -> assistantsRepository.delete(assistant));
    	
    	 assistantsRepository.deleteById(Id);
    }

}
