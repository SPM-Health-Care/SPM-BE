package org.example.behealthcare.repository;

import org.example.behealthcare.dto.MoodTrackingDTO;
import org.example.behealthcare.entity.MoodTracking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface IMoodTrackingRepository extends JpaRepository<MoodTracking, Long> {
    void deleteByMoodId(Integer moodId);

    void deleteByRecordedAt(LocalDate recordedAt);

    @Query("SELECT new org.example.behealthcare.dto.MoodTrackingDTO(" +
            "mt.moodId, u.userId, mt.mood, mt.recordedAt, mt.stressLevel) " +
            "FROM MoodTracking mt " +
            "JOIN mt.user u " +
            "WHERE u.userId = :userId")
    List<MoodTrackingDTO> findAllDtoByUserId(@Param("userId") Integer userId);
}
