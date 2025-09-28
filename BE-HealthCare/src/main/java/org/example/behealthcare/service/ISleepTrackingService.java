package org.example.behealthcare.service;

import org.example.behealthcare.dto.SleepTrackingCreateDTO;
import org.example.behealthcare.dto.SleepTrackingDTO;
import org.example.behealthcare.entity.SleepTracking;

import java.time.LocalDate;
import java.util.List;

public interface ISleepTrackingService {
    void deleteBySleepId(Integer sleepId);

    void deleteByUser_UserId(Integer userId);

    List<SleepTrackingDTO> findByUser_UserId(Integer userId);

    SleepTracking save(SleepTracking sleepTracking);

    SleepTracking update(Integer userId, LocalDate recordedAt, SleepTrackingDTO dto);

    SleepTracking create(SleepTrackingCreateDTO dto);
}
