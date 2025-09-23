package org.example.behealthcare.service.imp;

import org.example.behealthcare.entity.HealthGoal;
import org.example.behealthcare.repository.HealthGoalRepository;
import org.example.behealthcare.service.IHealthGoalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HealthGoalService implements IHealthGoalService {
    @Autowired
    private HealthGoalRepository healthGoalRepository;

    @Override
    public HealthGoal findByGoalId(Integer goalId) {
        return healthGoalRepository.findByGoalId(goalId);
    }

    @Override
    public void deleteByGoalId(Integer goalId) {
        healthGoalRepository.deleteByGoalId(goalId);
    }

    @Override
    public List<HealthGoal> findAllByUser_UserId(Integer userId) {
        return healthGoalRepository.findAllByUser_UserId(userId);
    }

    @Override
    public HealthGoal save(HealthGoal healthGoal) {
        return healthGoalRepository.save(healthGoal);
    }
}
