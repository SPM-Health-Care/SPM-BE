package org.example.behealthcare.service;

import org.example.behealthcare.dto.HealthGoalDTO;
import org.example.behealthcare.entity.HealthGoal;

import java.util.List;

public interface IHealthGoalService {
    HealthGoal findByGoalId(Integer goalId);

    void deleteByGoalId(Integer goalId);

    List<HealthGoalDTO> findAllByUser_UserId(Integer userId);

    HealthGoal save(HealthGoal healthGoal);

    HealthGoal update(Integer userId ,HealthGoalDTO healthGoalDto);
}
