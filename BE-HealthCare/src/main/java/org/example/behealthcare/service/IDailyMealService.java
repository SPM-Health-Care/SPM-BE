package org.example.behealthcare.service;

import org.example.behealthcare.dto.DailyMealDTO;
import org.example.behealthcare.entity.DailyMeal;

import java.time.LocalDate;
import java.util.List;

public interface IDailyMealService {
    void deleteByMealId(Integer mealId);

    void deleteByRecordedAt(LocalDate recordedAt);

    DailyMeal findByMealId(Integer mealId);

    List<DailyMealDTO> findAllByUser_UserId(Integer userId);

    DailyMeal save(DailyMeal dailyMeal);
}
