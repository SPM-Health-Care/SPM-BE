package org.example.behealthcare.service;

import org.example.behealthcare.entity.MoodTracking;

import java.time.LocalDate;
import java.util.List;

public interface IMoodTrackingService {
    void deleteByMoodId(Integer moodId);

    void deleteByRecordedAt(LocalDate recordedAt);

    List<MoodTracking> findAllByUser_UserId(Integer userId);

    MoodTracking save(MoodTracking moodTracking);
}
