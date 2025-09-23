package org.example.behealthcare.service;

import org.example.behealthcare.entity.SleepTracking;

public interface ISleepTrackingService {
    void deleteBySleepId(Integer sleepId);

    void deleteByUser_UserId(Integer userUserId);

    SleepTracking findByUser_UserId(Integer userUserId);

    SleepTracking save(SleepTracking sleepTracking);
}
