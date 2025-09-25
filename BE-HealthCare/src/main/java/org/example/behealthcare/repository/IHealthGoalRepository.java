package org.example.behealthcare.repository;

import org.example.behealthcare.entity.HealthGoal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IHealthGoalRepository extends JpaRepository<HealthGoal, Integer> {
    HealthGoal findByGoalId(Integer goalId);

    void deleteByGoalId(Integer goalId);

    List<HealthGoal> findAllByUser_UserId(Integer userId);

}
