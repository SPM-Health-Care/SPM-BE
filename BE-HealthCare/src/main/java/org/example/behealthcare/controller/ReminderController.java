package org.example.behealthcare.controller;

import org.example.behealthcare.dto.ReminderCreateDTO;
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

    @PutMapping("/reminders/{reminderId}/{userId}")
    public ResponseEntity<ReminderDTO> updateStatus(
            @PathVariable Integer reminderId,
            @PathVariable Integer userId,
            @RequestBody ReminderDTO dto) {

        Reminder updated = reminderService.update(reminderId, userId, dto);
        if (updated != null) {
            return ResponseEntity.ok(new ReminderDTO(updated));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/reminders-create")
    public ResponseEntity<Reminder> create(@RequestBody ReminderCreateDTO dto) {
        return ResponseEntity.ok(reminderService.create(dto));
    }

    @DeleteMapping("/reminders/{reminderId}")
    public ResponseEntity<Void> deleteReminder(@PathVariable Integer reminderId) {
        reminderService.deleteByReminderId(reminderId);
        return ResponseEntity.noContent().build();
    }
}
