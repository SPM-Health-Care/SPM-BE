package org.example.behealthcare.service.imp;

import org.example.behealthcare.entity.SleepTracking;
import org.example.behealthcare.repository.ISleepTrackingRepository;
import org.example.behealthcare.service.ISleepTrackingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SleepTrackingService implements ISleepTrackingService {
    @Autowired
    private ISleepTrackingRepository ISleepTrackingRepository;

    @Override
    public void deleteBySleepId(Integer sleepId) {
        ISleepTrackingRepository.deleteBySleepId(sleepId);
    }

    @Override
    public void deleteByUser_UserId(Integer userUserId) {
        ISleepTrackingRepository.deleteByUser_UserId(userUserId);
    }

    @Override
    public List<SleepTracking> findByUser_UserId(Integer userUserId) {
        return ISleepTrackingRepository.findByUser_UserId(userUserId);
    }

    @Override
    public SleepTracking save(SleepTracking sleepTracking) {
        return ISleepTrackingRepository.save(sleepTracking);
    }
}
