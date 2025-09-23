package org.example.behealthcare.service.imp;

import org.example.behealthcare.entity.SleepTracking;
import org.example.behealthcare.repository.SleepTrackingRepository;
import org.example.behealthcare.service.ISleepTrackingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SleepTrackingService implements ISleepTrackingService {
    @Autowired
    private SleepTrackingRepository sleepTrackingRepository;

    @Override
    public void deleteBySleepId(Integer sleepId) {
        sleepTrackingRepository.deleteBySleepId(sleepId);
    }

    @Override
    public void deleteByUser_UserId(Integer userUserId) {
        sleepTrackingRepository.deleteByUser_UserId(userUserId);
    }

    @Override
    public SleepTracking findByUser_UserId(Integer userUserId) {
        return sleepTrackingRepository.findByUser_UserId(userUserId);
    }

    @Override
    public SleepTracking save(SleepTracking sleepTracking) {
        return sleepTrackingRepository.save(sleepTracking);
    }
}
