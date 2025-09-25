package org.example.behealthcare.controller;

import org.example.behealthcare.entity.SleepTracking;
import org.example.behealthcare.service.ISleepTrackingService;
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
public class SleepTrackingController {
    @Autowired
    private ISleepTrackingService sleepTrackingService;

    @GetMapping("/sleeptrackings/{userId}")
    public ResponseEntity<List<SleepTracking>> showSleepTrackingsByUserId(Integer userId) {
        List<SleepTracking> sleepTrackings = sleepTrackingService.findByUser_UserId(userId);
        if (!sleepTrackings.isEmpty()) {
            return ResponseEntity.ok(sleepTrackings);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


}
