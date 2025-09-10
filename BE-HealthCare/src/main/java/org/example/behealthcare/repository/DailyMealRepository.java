package org.example.behealthcare.repository;

import org.example.behealthcare.entity.DailyMeal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DailyMealRepository extends JpaRepository<DailyMeal, Integer> {
}
