package org.example.behealthcare.controller;

import org.example.behealthcare.dto.DailyMealDTO;
import org.example.behealthcare.entity.DailyMeal;
import org.example.behealthcare.service.IDailyMealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class DailyMealController {
    @Autowired
    private IDailyMealService dailyMealService;

    @GetMapping("/dailymeals/{userId}")
    public ResponseEntity<List<DailyMealDTO>> showDailyMealsByUserId(@PathVariable Integer userId) {
        List<DailyMealDTO> dailyMeals = dailyMealService.findAllByUser_UserId(userId);
        System.out.println(dailyMeals);
        if (!dailyMeals.isEmpty()) {
            return ResponseEntity.ok(dailyMeals);
        } else {
            return ResponseEntity.notFound().build();
        }

    }
}
