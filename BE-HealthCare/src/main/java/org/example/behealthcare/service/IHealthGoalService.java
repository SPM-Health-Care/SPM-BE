package org.example.behealthcare.service;

import org.example.behealthcare.entity.HealthGoal;

import java.util.List;

public interface IHealthGoalService {
    HealthGoal findByGoalId(Integer goalId);

    void deleteByGoalId(Integer goalId);

    List<HealthGoal> findAllByUser_UserId(Integer userId);

    HealthGoal save(HealthGoal healthGoal);
}
