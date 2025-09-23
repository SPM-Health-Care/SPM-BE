package org.example.behealthcare.repository;

import org.example.behealthcare.entity.HealthMetric;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface HealthMetricRepository extends JpaRepository<HealthMetric, Long> {
    HealthMetric findByMetricId(Integer metricId);

    void deleteByMetricId(Integer metricId);

    void deleteByRecordedAt(LocalDate recordedAt);

    List<HealthMetric> findByUser_UserId(Integer userId);

    List<HealthMetric> findByThreshold_ThresholdId(Integer thresholdId);
}
