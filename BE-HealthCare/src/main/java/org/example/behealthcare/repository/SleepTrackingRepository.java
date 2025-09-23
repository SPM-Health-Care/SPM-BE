package org.example.behealthcare.repository;

import org.example.behealthcare.entity.SleepTracking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SleepTrackingRepository extends JpaRepository<SleepTracking, Long> {
    void deleteBySleepId(Integer sleepId);

    void deleteByUser_UserId(Integer userUserId);

    SleepTracking findByUser_UserId(Integer userUserId);
}
