package org.example.behealthcare.controller;

import org.example.behealthcare.dto.MoodTrackingDTO;
import org.example.behealthcare.entity.MoodTracking;
import org.example.behealthcare.service.IMoodTrackingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class MoodTrackingController {
    @Autowired
    private IMoodTrackingService moodTrackingService;

    @GetMapping("/moodtrackings/{userId}")
    public ResponseEntity<List<MoodTrackingDTO>> showMoodTrackingsByUserId(@PathVariable Integer userId) {
        List<MoodTrackingDTO> moodTrackings = moodTrackingService.findAllDtoByUserId(userId);
        System.out.println(moodTrackings);
        if (!moodTrackings.isEmpty()) {
            return ResponseEntity.ok(moodTrackings);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
