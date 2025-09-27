package org.example.behealthcare.repository;

import org.example.behealthcare.dto.HealthGoalDTO;
import org.example.behealthcare.entity.HealthGoal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IHealthGoalRepository extends JpaRepository<HealthGoal, Integer> {
    HealthGoal findByGoalId(Integer goalId);

    void deleteByGoalId(Integer goalId);

    @Query("SELECT new org.example.behealthcare.dto.HealthGoalDTO(" +
            "hg.goalId, hg.user.userId, hg.weightGoal, hg.bpGoal) " +
            "FROM HealthGoal hg " +
            "WHERE hg.user.userId = :userId"
    )
    List<HealthGoalDTO> findAllByUser_UserId(Integer userId);

    @Query("SELECT hg FROM HealthGoal hg WHERE hg.user.userId = :userId")
    Optional<HealthGoal> findByUser_UserId(Integer userId);

}
