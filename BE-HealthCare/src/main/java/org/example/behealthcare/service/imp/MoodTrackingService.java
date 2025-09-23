package org.example.behealthcare.service.imp;

import org.example.behealthcare.entity.MoodTracking;
import org.example.behealthcare.repository.MoodTrackingRepository;
import org.example.behealthcare.service.IMoodTrackingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class MoodTrackingService implements IMoodTrackingService {
    @Autowired
    private MoodTrackingRepository moodTrackingRepository;

    @Override
    public void deleteByMoodId(Integer moodId) {
        moodTrackingRepository.deleteByMoodId(moodId);
    }

    @Override
    public void deleteByRecordedAt(LocalDate recordedAt) {
        moodTrackingRepository.deleteByRecordedAt(recordedAt);
    }

    @Override
    public List<MoodTracking> findAllByUser_UserId(Integer userId) {
        return moodTrackingRepository.findAllByUser_UserId(userId);
    }

    @Override
    public MoodTracking save(MoodTracking moodTracking) {
        return moodTrackingRepository.save(moodTracking);
    }
}
