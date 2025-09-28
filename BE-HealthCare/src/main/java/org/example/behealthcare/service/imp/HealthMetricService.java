package org.example.behealthcare.service.imp;

import lombok.RequiredArgsConstructor;
import org.example.behealthcare.dto.HealthMetricCreateDTO;
import org.example.behealthcare.dto.HealthMetricDTO;
import org.example.behealthcare.entity.HealthMetric;
import org.example.behealthcare.entity.HealthThreshold;
import org.example.behealthcare.entity.User;
import org.example.behealthcare.exception.AppException;
import org.example.behealthcare.exception.ErrorCode;
import org.example.behealthcare.repository.IHealthMetricRepository;
import org.example.behealthcare.repository.IHealthThresholdRepository;
import org.example.behealthcare.repository.UserRepository;
import org.example.behealthcare.service.IHealthMetricService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class HealthMetricService implements IHealthMetricService {
    @Autowired
    private IHealthMetricRepository IHealthMetricRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private IHealthThresholdRepository healthThresholdRepository;

    @Override
    public HealthMetric findByMetricId(Integer metricId) {
        return IHealthMetricRepository.findByMetricId(metricId);
    }

    @Override
    public void deleteByMetricId(Integer metricId) {
        IHealthMetricRepository.deleteByMetricId(metricId);
    }

    @Override
    public void deleteByRecordedAt(LocalDate recordedAt) {
        IHealthMetricRepository.deleteByRecordedAt(recordedAt);
    }

    @Override
    public List<HealthMetricDTO> findByUser_UserId(Integer userId) {
        return IHealthMetricRepository.findByUser_UserId(userId);
    }

    @Override
    public HealthMetric save(HealthMetric healthMetric) {
        return IHealthMetricRepository.save(healthMetric);
    }

    @Override
    public HealthMetric update(Integer userId, LocalDate recordedAt, HealthMetricDTO dto) {
        HealthMetric metric = IHealthMetricRepository.findByUserIdAndDate(userId, recordedAt)
                .orElseThrow(() -> new AppException(ErrorCode.UNCATEGORIZED_EXCEPTION));
        if (dto.getHeartRate() != null) metric.setHeartRate(dto.getHeartRate());
        if (dto.getBloodPressure() != null) metric.setBloodPressure(dto.getBloodPressure());
        return IHealthMetricRepository.save(metric);
    }

    @Override
    public HealthMetric create(HealthMetricCreateDTO dto) {
        User user = userRepository.findById(dto.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        HealthThreshold threshold = healthThresholdRepository.findById(dto.getThresholdId())
                .orElseThrow(() -> new RuntimeException("Threshold not found"));

        HealthMetric metric = HealthMetric.builder()
                .bloodPressure(dto.getBloodPressure())
                .heartRate(dto.getHeartRate())
                .weight(dto.getWeight())
                .recordedAt(dto.getRecordedAt())
                .user(user)
                .threshold(threshold)
                .build();

        return IHealthMetricRepository.save(metric);
    }


}

