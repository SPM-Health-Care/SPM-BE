package org.example.behealthcare.repository;

import org.example.behealthcare.entity.HealthThreshold;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IHealthThresholdRepository extends JpaRepository<HealthThreshold, Integer> {
    HealthThreshold findByThresholdId(Integer thresholdId);
}
