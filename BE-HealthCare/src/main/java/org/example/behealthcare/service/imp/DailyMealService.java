package org.example.behealthcare.service.imp;

import org.example.behealthcare.entity.DailyMeal;
import org.example.behealthcare.repository.DailyMealRepository;
import org.example.behealthcare.service.IDailyMealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
@Service
public class DailyMealService implements IDailyMealService {
    @Autowired
    private DailyMealRepository dailyMealRepository;

    @Override
    public void deleteByMealId(Integer mealId) {
        dailyMealRepository.deleteByMealId(mealId);
    }

    @Override
    public void deleteByRecordedAt(LocalDate recordedAt) {
        dailyMealRepository.deleteByRecordedAt(recordedAt);
    }

    @Override
    public DailyMeal findByMealId(Integer mealId) {
        return dailyMealRepository.findByMealId(mealId);
    }

    @Override
    public List<DailyMeal> findAllByUser_UserId(Integer userId) {
        return dailyMealRepository.findAllByUser_UserId(userId);
    }

    @Override
    public DailyMeal save(DailyMeal dailyMeal) {
        return dailyMealRepository.save(dailyMeal);
    }
}
