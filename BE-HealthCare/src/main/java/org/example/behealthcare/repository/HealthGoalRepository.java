package org.example.behealthcare.repository;

import org.example.behealthcare.entity.HealthGoal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HealthGoalRepository extends JpaRepository<HealthGoal, Integer> {
}
