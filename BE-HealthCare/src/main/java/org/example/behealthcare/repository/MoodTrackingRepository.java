package org.example.behealthcare.repository;

import org.example.behealthcare.entity.MoodTracking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface MoodTrackingRepository extends JpaRepository<MoodTracking, Long> {
    void deleteByMoodId(Integer moodId);

    void deleteByRecordedAt(LocalDate recordedAt);

    List<MoodTracking> findAllByUser_UserId(Integer userId);
}
