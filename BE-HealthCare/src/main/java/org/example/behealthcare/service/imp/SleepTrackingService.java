package org.example.behealthcare.service.imp;

import org.example.behealthcare.dto.SleepTrackingDTO;
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
    public void deleteByUser_UserId(Integer userId) {
        ISleepTrackingRepository.deleteByUser_UserId(userId);
    }

    @Override
    public List<SleepTrackingDTO> findByUser_UserId(Integer userId) {
        return ISleepTrackingRepository.findByUser_UserId(userId);
    }

    @Override
    public SleepTracking save(SleepTracking sleepTracking) {
        return ISleepTrackingRepository.save(sleepTracking);
    }
}
