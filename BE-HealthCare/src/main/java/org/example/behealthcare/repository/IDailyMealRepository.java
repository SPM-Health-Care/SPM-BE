package org.example.behealthcare.repository;

import org.example.behealthcare.dto.DailyMealDTO;
import org.example.behealthcare.entity.DailyMeal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface IDailyMealRepository extends JpaRepository<DailyMeal, Integer> {
    void deleteByMealId(Integer mealId);

    void deleteByRecordedAt(LocalDate recordedAt);

    DailyMeal findByMealId(Integer mealId);


//    @Query("SELECT dm.mealId, dm.calories, dm.recordedAt, f.foodName " +
//            "FROM DailyMeal dm " +
//            "JOIN dm.food f " +
//            "WHERE dm.user.userId = :userId")
//    List<DailyMeal> findAllByUser_UserId(@Param("userId") Integer userId);

    @Query("SELECT new org.example.behealthcare.dto.DailyMealDTO( " +
            "dm.mealId, u.userId, f.foodId, f.foodName, dm.calories, dm.recordedAt) " +
            "FROM DailyMeal dm " +
            "JOIN dm.user u " +
            "JOIN dm.food f " +
            "WHERE u.userId = :userId")
    List<DailyMealDTO> findAllByUser_UserId(@Param("userId") Integer userId);


}
