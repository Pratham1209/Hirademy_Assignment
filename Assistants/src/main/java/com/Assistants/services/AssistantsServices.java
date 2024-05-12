package com.Assistants.services;

import java.util.List;
import com.Assistants.entity.Assistants;

public interface AssistantsServices {
    //create
    String create(Assistants assistant);

    //get all assistants
    List<Assistants> getAssistants();

    //get single assistant
    Assistants getAssistant(String id);

    //update Assistants
    Assistants updateAssistant(String id, Assistants assistant);

    //delete
    void deleteAssistantUsingId(String Id);
}
