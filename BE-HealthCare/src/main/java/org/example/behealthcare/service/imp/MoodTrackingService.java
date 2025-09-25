package org.example.behealthcare.service.imp;

import org.example.behealthcare.dto.MoodTrackingDTO;
import org.example.behealthcare.entity.MoodTracking;
import org.example.behealthcare.repository.IMoodTrackingRepository;
import org.example.behealthcare.service.IMoodTrackingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class MoodTrackingService implements IMoodTrackingService {
    @Autowired
    private IMoodTrackingRepository IMoodTrackingRepository;

    @Override
    public void deleteByMoodId(Integer moodId) {
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
}
