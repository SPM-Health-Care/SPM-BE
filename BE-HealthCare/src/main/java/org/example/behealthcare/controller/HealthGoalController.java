package org.example.behealthcare.controller;

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
    public ResponseEntity<List<HealthGoal>> showHealthGoalsByUserId(@PathVariable Integer userId) {
        List<HealthGoal> healthGoals = healthGoalService.findAllByUser_UserId(userId);
        System.out.println(healthGoals);
        if (!healthGoals.isEmpty()) {
            return ResponseEntity.ok(healthGoals);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
