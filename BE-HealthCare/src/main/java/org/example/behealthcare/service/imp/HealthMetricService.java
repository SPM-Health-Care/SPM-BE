package org.example.behealthcare.service.imp;

import org.example.behealthcare.entity.HealthMetric;
import org.example.behealthcare.repository.HealthMetricRepository;
import org.example.behealthcare.service.IHealthMetricService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
@Service
public class HealthMetricService implements IHealthMetricService {
    @Autowired
    private HealthMetricRepository healthMetricRepository;

    @Override
    public HealthMetric findByMetricId(Integer metricId) {
        return healthMetricRepository.findByMetricId(metricId);
    }

    @Override
    public void deleteByMetricId(Integer metricId) {
        healthMetricRepository.deleteByMetricId(metricId);
    }

    @Override
    public void deleteByRecordedAt(LocalDate recordedAt) {
        healthMetricRepository.deleteByRecordedAt(recordedAt);
    }

    @Override
    public List<HealthMetric> findByUser_UserId(Integer userId) {
        return healthMetricRepository.findByUser_UserId(userId);
    }

    @Override
    public List<HealthMetric> findByThreshold_ThresholdId(Integer thresholdId) {
        return healthMetricRepository.findByThreshold_ThresholdId(thresholdId);
    }

    @Override
    public HealthMetric save(HealthMetric healthMetric) {
        return healthMetricRepository.save(healthMetric);
    }
}
