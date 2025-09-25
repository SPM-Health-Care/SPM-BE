package org.example.behealthcare.controller;

import org.example.behealthcare.dto.ReminderDTO;
import org.example.behealthcare.entity.Reminder;
import org.example.behealthcare.service.IReminderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class ReminderController {
    @Autowired
    private IReminderService reminderService;
    @GetMapping("/reminders/{userId}")
    public ResponseEntity<List<ReminderDTO>> showRemindersByUserId(@PathVariable Integer userId) {
        List<ReminderDTO> reminders = reminderService.findByUser_UserId(userId);
        System.out.println(reminders);
        if (!reminders.isEmpty()) {
            return ResponseEntity.ok(reminders);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
