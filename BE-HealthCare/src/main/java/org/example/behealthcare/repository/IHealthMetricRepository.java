package org.example.behealthcare.repository;

import org.example.behealthcare.dto.HealthMetricDTO;
import org.example.behealthcare.entity.HealthMetric;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface IHealthMetricRepository extends JpaRepository<HealthMetric, Long> {
    HealthMetric findByMetricId(Integer metricId);

    void deleteByMetricId(Integer metricId);

    void deleteByRecordedAt(LocalDate recordedAt);

    @Query("SELECT new org.example.behealthcare.dto.HealthMetricDTO(" +
            "hm.metricId, hm.bloodPressure, hm.heartRate, hm.weight, hm.recordedAt, " +
            "t.maxValue, t.minValue, t.metricType) " +
            "FROM HealthMetric hm " +
            "JOIN hm.threshold t " +
            "WHERE hm.user.userId = :userId")
    List<HealthMetricDTO> findByUser_UserId(@Param("userId") Integer userId);

    @Query("SELECT hm " +
            "FROM HealthMetric hm " +
            "JOIN FETCH hm.threshold t " +
            "WHERE hm.user.userId = :userId " +
            "AND DATE(hm.recordedAt) = :recordedAt")
    Optional<HealthMetric> findByUserIdAndDate(
            @Param("userId") Integer userId,
            @Param("recordedAt") LocalDate recordedAt);
}
