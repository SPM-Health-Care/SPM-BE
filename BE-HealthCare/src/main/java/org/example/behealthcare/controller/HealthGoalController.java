package org.example.behealthcare.controller;

import org.example.behealthcare.dto.HealthGoalDTO;
import org.example.behealthcare.entity.HealthGoal;
import org.example.behealthcare.service.IHealthGoalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class HealthGoalController {
    @Autowired
    private IHealthGoalService healthGoalService;

    @GetMapping("/healthgoals/{userId}")
    public ResponseEntity<List<HealthGoalDTO>> showHealthGoalsByUserId(@PathVariable Integer userId) {
        List<HealthGoalDTO> healthGoals = healthGoalService.findAllByUser_UserId(userId);
        System.out.println(healthGoals);
        if (!healthGoals.isEmpty()) {
            return ResponseEntity.ok(healthGoals);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/goals/{userId}")
    public ResponseEntity<HealthGoalDTO> updateGoal(
            @PathVariable Integer userId,
            @RequestBody HealthGoalDTO dto) {

        HealthGoal updated = healthGoalService.update(userId, dto);

        if (updated != null) {
            // Trả về DTO thay vì entity để tránh lộ dữ liệu nhạy cảm
            return ResponseEntity.ok(new HealthGoalDTO(updated));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
