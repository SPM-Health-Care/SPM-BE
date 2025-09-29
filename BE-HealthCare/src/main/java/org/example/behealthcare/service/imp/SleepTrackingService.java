package org.example.behealthcare.service.imp;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.behealthcare.dto.SleepTrackingCreateDTO;
import org.example.behealthcare.dto.SleepTrackingDTO;
import org.example.behealthcare.entity.SleepTracking;
import org.example.behealthcare.entity.User;
import org.example.behealthcare.exception.AppException;
import org.example.behealthcare.exception.ErrorCode;
import org.example.behealthcare.repository.ISleepTrackingRepository;
import org.example.behealthcare.repository.UserRepository;
import org.example.behealthcare.service.ISleepTrackingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class SleepTrackingService implements ISleepTrackingService {
    @Autowired
    private ISleepTrackingRepository ISleepTrackingRepository;

    @Autowired
    private UserRepository userRepository;

    @Transactional
    public void deleteBySleepId(Integer sleepId) {
        if (!ISleepTrackingRepository.existsById(Long.valueOf(sleepId))) {
            throw new AppException(ErrorCode.UNCATEGORIZED_EXCEPTION);
        }
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

    @Override
    public SleepTracking update(Integer userId, LocalDate recordedAt, SleepTrackingDTO dto) {
        SleepTracking sleepTracking = ISleepTrackingRepository.findByUserIdAndDate(userId, recordedAt)
                .orElseThrow(() -> new AppException(ErrorCode.UNCATEGORIZED_EXCEPTION));
        if (dto.getSleepTime() != null) sleepTracking.setSleepTime(dto.getSleepTime());
        if (dto.getWakeTime() != null) sleepTracking.setWakeTime(dto.getWakeTime());
        return ISleepTrackingRepository.save(sleepTracking);
    }

    @Override
    public SleepTracking create(SleepTrackingCreateDTO dto) {
        User user = userRepository.findById(dto.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        SleepTracking sleepTracking = SleepTracking.builder()
                .user(user)
                .recordedAt(dto.getRecordedAt())
                .sleepTime(dto.getSleepTime())
                .wakeTime(dto.getWakeTime())
                .build();
        return ISleepTrackingRepository.save(sleepTracking);
    }
}
