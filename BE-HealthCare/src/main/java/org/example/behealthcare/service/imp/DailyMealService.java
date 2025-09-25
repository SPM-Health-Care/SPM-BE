package org.example.behealthcare.service.imp;

import org.example.behealthcare.dto.DailyMealDTO;
import org.example.behealthcare.entity.DailyMeal;
import org.example.behealthcare.repository.IDailyMealRepository;
import org.example.behealthcare.service.IDailyMealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
@Service
public class DailyMealService implements IDailyMealService {
    @Autowired
    private IDailyMealRepository IDailyMealRepository;

    @Override
    public void deleteByMealId(Integer mealId) {
        IDailyMealRepository.deleteByMealId(mealId);
    }

    @Override
    public void deleteByRecordedAt(LocalDate recordedAt) {
        IDailyMealRepository.deleteByRecordedAt(recordedAt);
    }

    @Override
    public DailyMeal findByMealId(Integer mealId) {
        return IDailyMealRepository.findByMealId(mealId);
    }

    @Override
    public List<DailyMealDTO> findAllByUser_UserId(Integer userId) {
        return IDailyMealRepository.findAllByUser_UserId(userId);
    }

    @Override
    public DailyMeal save(DailyMeal dailyMeal) {
        return IDailyMealRepository.save(dailyMeal);
    }
}
