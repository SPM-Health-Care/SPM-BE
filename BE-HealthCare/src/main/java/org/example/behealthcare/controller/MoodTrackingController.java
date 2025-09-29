package org.example.behealthcare.controller;

import org.example.behealthcare.dto.MoodTrackingCreateDTO;
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

    @PutMapping("/moodtrackings/{userId}/{moodId}")
    public ResponseEntity<MoodTrackingDTO> updateMoodTracking(
            @PathVariable Integer moodId,
            @PathVariable Integer userId,
            @RequestBody MoodTrackingDTO dto) {
        MoodTracking updated = moodTrackingService.update(userId, moodId, dto);
        if (updated != null) {
            return ResponseEntity.ok(new MoodTrackingDTO(updated));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/moodtrackings-create")
    public ResponseEntity<MoodTracking> create(@RequestBody MoodTrackingCreateDTO dto) {
        return ResponseEntity.ok(moodTrackingService.create(dto));
    }

    @DeleteMapping("/moodtrackings/{moodId}")
    public ResponseEntity<Void> deleteMoodTracking(@PathVariable Integer moodId) {
        moodTrackingService.deleteByMoodId(moodId);
        return ResponseEntity.noContent().build();
    }
}
