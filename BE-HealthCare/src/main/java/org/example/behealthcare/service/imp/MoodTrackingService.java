package org.example.behealthcare.service.imp;

import jakarta.transaction.Transactional;
import org.example.behealthcare.dto.MoodTrackingCreateDTO;
import org.example.behealthcare.dto.MoodTrackingDTO;
import org.example.behealthcare.entity.MoodTracking;
import org.example.behealthcare.entity.User;
import org.example.behealthcare.exception.AppException;
import org.example.behealthcare.exception.ErrorCode;
import org.example.behealthcare.repository.IMoodTrackingRepository;
import org.example.behealthcare.repository.UserRepository;
import org.example.behealthcare.service.IMoodTrackingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class MoodTrackingService implements IMoodTrackingService {
    @Autowired
    private IMoodTrackingRepository IMoodTrackingRepository;

    @Autowired
    private UserRepository userRepository;

    @Transactional
    public void deleteByMoodId(Integer moodId) {
        if (!IMoodTrackingRepository.existsById(Long.valueOf(moodId))) {
            throw new AppException(ErrorCode.UNCATEGORIZED_EXCEPTION);
        }
        IMoodTrackingRepository.deleteByMoodId(moodId);
    }

    @Override
    public void deleteByRecordedAt(LocalDate recordedAt) {
        IMoodTrackingRepository.deleteByRecordedAt(recordedAt);
    }

    @Override
    public List<MoodTrackingDTO> findAllDtoByUserId(Integer userId) {
        return IMoodTrackingRepository.findAllDtoByUserId(userId);
    }


    @Override
    public MoodTracking save(MoodTracking moodTracking) {
        return IMoodTrackingRepository.save(moodTracking);
    }

    @Override
    public MoodTracking update(Integer moodId, Integer userId, MoodTrackingDTO dto) {
            MoodTracking moodTracking = IMoodTrackingRepository.findByMoodIdAndUserId(moodId, userId)
                    .orElseThrow(()-> new RuntimeException("MoodTracking not found"));
            if (dto.getMood() != null) moodTracking.setMood(dto.getMood());
            if (dto.getStressLevel() != null) moodTracking.setStressLevel(dto.getStressLevel());
            return IMoodTrackingRepository.save(moodTracking);
    }

    @Override
    public MoodTracking create(MoodTrackingCreateDTO dto) {
        User user = userRepository.findById(dto.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));
        MoodTracking moodTracking =MoodTracking.builder()
                .user(user)
                .mood(dto.getMood())
                .recordedAt(dto.getRecordedAt())
                .stressLevel(dto.getStressLevel())
                .build();
        return IMoodTrackingRepository.save(moodTracking);
    }
}
