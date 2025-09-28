package org.example.behealthcare.service;

import org.example.behealthcare.dto.HealthMetricCreateDTO;
import org.example.behealthcare.dto.HealthMetricDTO;
import org.example.behealthcare.entity.HealthMetric;

import java.time.LocalDate;
import java.util.List;

public interface IHealthMetricService {
    HealthMetric findByMetricId(Integer metricId);

    void deleteByMetricId(Integer metricId);

    void deleteByRecordedAt(LocalDate recordedAt);

    List<HealthMetricDTO> findByUser_UserId(Integer userId);

    HealthMetric save(HealthMetric healthMetric);

    HealthMetric update(Integer userId, LocalDate recordedAt, HealthMetricDTO dto);

    HealthMetric create(HealthMetricCreateDTO dto);
}
