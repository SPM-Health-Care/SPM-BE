package org.example.behealthcare.controller;

import jakarta.validation.Valid;
import org.example.behealthcare.dto.SleepTrackingCreateDTO;
import org.example.behealthcare.dto.SleepTrackingDTO;
import org.example.behealthcare.entity.SleepTracking;
import org.example.behealthcare.service.ISleepTrackingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class SleepTrackingController {
    @Autowired
    private ISleepTrackingService sleepTrackingService;

    @GetMapping("/sleeptrackings/{userId}")
    public ResponseEntity<List<SleepTrackingDTO>> showSleepTrackingsByUserId(@PathVariable Integer userId) {
        List<SleepTrackingDTO> sleepTrackings = sleepTrackingService.findByUser_UserId(userId);
        System.out.println(sleepTrackings);
        if (!sleepTrackings.isEmpty()) {
            return ResponseEntity.ok(sleepTrackings);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/sleeptrackings/{userId}/{recordedAt}")
    public ResponseEntity<SleepTrackingDTO> updateSleepTracking(
            @PathVariable Integer userId,
            @PathVariable LocalDate recordedAt,
            @RequestBody SleepTrackingDTO dto) {
        SleepTracking updated = sleepTrackingService.update(userId, recordedAt, dto);
        if (updated != null) {
            return ResponseEntity.ok(new SleepTrackingDTO(updated));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/sleeptrackings-create")
    public ResponseEntity<SleepTracking> create(@Valid @RequestBody SleepTrackingCreateDTO dto) {
        return ResponseEntity.ok(sleepTrackingService.create(dto));
    }
}
