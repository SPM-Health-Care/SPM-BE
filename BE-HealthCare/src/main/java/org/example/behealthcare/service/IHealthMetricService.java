package org.example.behealthcare.service;

import org.example.behealthcare.entity.HealthMetric;

import java.time.LocalDate;
import java.util.List;

public interface IHealthMetricService {
    HealthMetric findByMetricId(Integer metricId);

    void deleteByMetricId(Integer metricId);

    void deleteByRecordedAt(LocalDate recordedAt);

    List<HealthMetric> findByUser_UserId(Integer userId);

    List<HealthMetric> findByThreshold_ThresholdId(Integer thresholdId);

    HealthMetric save(HealthMetric healthMetric);
}
