package org.example.behealthcare.repository;

import org.example.behealthcare.entity.HealthMetric;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HealthMetricRepository extends JpaRepository<HealthMetric, Long> {
}
