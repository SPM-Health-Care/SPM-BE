package org.example.behealthcare.service;

import org.example.behealthcare.dto.MoodTrackingCreateDTO;
import org.example.behealthcare.dto.MoodTrackingDTO;
import org.example.behealthcare.entity.MoodTracking;

import java.time.LocalDate;
import java.util.List;

public interface IMoodTrackingService {
    void deleteByMoodId(Integer moodId);

    void deleteByRecordedAt(LocalDate recordedAt);

    List<MoodTrackingDTO> findAllDtoByUserId(Integer userId);

    MoodTracking save(MoodTracking moodTracking);

    MoodTracking update(Integer userId, Integer moodId, MoodTrackingDTO dto);

    MoodTracking create(MoodTrackingCreateDTO dto);
}
