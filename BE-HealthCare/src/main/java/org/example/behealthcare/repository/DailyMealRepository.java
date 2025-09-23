package org.example.behealthcare.repository;

import org.example.behealthcare.entity.DailyMeal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface DailyMealRepository extends JpaRepository<DailyMeal, Integer> {
    void deleteByMealId(Integer mealId);

    void deleteByRecordedAt(LocalDate recordedAt);

    DailyMeal findByMealId(Integer mealId);

    List<DailyMeal> findAllByUser_UserId(Integer userId);

}
