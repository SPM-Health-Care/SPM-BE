package org.example.behealthcare.service;

import org.example.behealthcare.entity.SleepTracking;

import java.util.List;

public interface ISleepTrackingService {
    void deleteBySleepId(Integer sleepId);

    void deleteByUser_UserId(Integer userUserId);

    List<SleepTracking> findByUser_UserId(Integer userUserId);

    SleepTracking save(SleepTracking sleepTracking);
}
