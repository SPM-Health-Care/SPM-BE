package org.example.behealthcare.service.imp;

import org.example.behealthcare.dto.HealthGoalDTO;
import org.example.behealthcare.entity.HealthGoal;
import org.example.behealthcare.exception.AppException;
import org.example.behealthcare.exception.ErrorCode;
import org.example.behealthcare.repository.IHealthGoalRepository;
import org.example.behealthcare.service.IHealthGoalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HealthGoalService implements IHealthGoalService {
    @Autowired
    private IHealthGoalRepository IHealthGoalRepository;

    @Override
    public HealthGoal findByGoalId(Integer goalId) {
        return IHealthGoalRepository.findByGoalId(goalId);
    }

    @Override
    public void deleteByGoalId(Integer goalId) {
        IHealthGoalRepository.deleteByGoalId(goalId);
    }

    @Override
    public List<HealthGoalDTO> findAllByUser_UserId(Integer userId) {
        return IHealthGoalRepository.findAllByUser_UserId(userId);
    }

    @Override
    public HealthGoal save(HealthGoal healthGoal) {
        return IHealthGoalRepository.save(healthGoal);
    }

    @Override
    public HealthGoal update(Integer userId, HealthGoalDTO dto) {
        // Tìm goal theo userId
        HealthGoal goal = IHealthGoalRepository.findByUser_UserId(userId)
                .orElseThrow(() -> new AppException(ErrorCode.UNCATEGORIZED_EXCEPTION));

        // Cập nhật dữ liệu
        if (dto.getWeightGoal() != null) goal.setWeightGoal(dto.getWeightGoal());
        if (dto.getBpGoal() != null) goal.setBpGoal(dto.getBpGoal());

        // Lưu và trả entity
        return IHealthGoalRepository.save(goal);
    }
}
