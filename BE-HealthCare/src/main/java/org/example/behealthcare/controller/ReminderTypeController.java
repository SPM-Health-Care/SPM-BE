package org.example.behealthcare.controller;

import org.example.behealthcare.entity.ReminderType;
import org.example.behealthcare.service.IReminderTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class ReminderTypeController {
    @Autowired
    private IReminderTypeService reminderTypeService;

    @GetMapping("/remindertypes")
    public ResponseEntity<List<ReminderType>> getAllReminderTypes() {
        List<ReminderType> reminderTypes = reminderTypeService.findAll();
        System.out.println(reminderTypes);
        if (!reminderTypes.isEmpty()) {
            return ResponseEntity.ok(reminderTypes);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
