package com.Assistants.controller;

import com.Assistants.entity.Assistants;
import com.Assistants.payload.ApiResponse;
import com.Assistants.services.AssistantsServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@RequestMapping("/api/assistants")
public class AssistantsController {

    @Autowired
    private AssistantsServices assistantsService;

    @PostMapping("/assistant")
    public ResponseEntity<String> createAssistant(@RequestBody Assistants assistant) {
        String newAssistantId = assistantsService.create(assistant);
        return ResponseEntity.status(HttpStatus.CREATED).body(newAssistantId);
    }

    @GetMapping("/assistant/{assistant_id}")
    public ResponseEntity<Assistants> getAssistantById(@PathVariable String assistant_id) {
        Assistants assistant = assistantsService.getAssistant(assistant_id);
        if (assistant != null) {
            return ResponseEntity.status(HttpStatus.OK).body(assistant);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping("/assistant/all")
    public ResponseEntity<List<Assistants>> getAssistants() {
        return ResponseEntity.ok(assistantsService.getAssistants());
    }

    @PutMapping("/assistant/{assistant_id}")
    public ResponseEntity<Assistants> updateAssistant(@RequestBody Assistants assistant, @PathVariable String assistant_id) {
        return ResponseEntity.status(HttpStatus.OK).body(assistantsService.updateAssistant(assistant_id, assistant));
    }

    @DeleteMapping("/assistant/{assistant_id}")
    public ApiResponse deleteAssistant(@PathVariable String assistant_id) {
        this.assistantsService.deleteAssistantUsingId(assistant_id);
        return new ApiResponse("Assistant is successfully deleted", true);
    }
}
