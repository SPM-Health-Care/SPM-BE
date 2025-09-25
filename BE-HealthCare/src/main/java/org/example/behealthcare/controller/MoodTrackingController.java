package org.example.behealthcare.controller;

import org.example.behealthcare.entity.MoodTracking;
import org.example.behealthcare.service.IMoodTrackingService;
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
public class MoodTrackingController {
    @Autowired
    private IMoodTrackingService moodTrackingService;

    @GetMapping("/moodtrackings/{userId}")
    public ResponseEntity<List<MoodTracking>> showMoodTrackingsByUserId(Integer userId) {
        List<MoodTracking> moodTrackings = moodTrackingService.findAllByUser_UserId(userId);
        if (!moodTrackings.isEmpty()) {
            return ResponseEntity.ok(moodTrackings);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
