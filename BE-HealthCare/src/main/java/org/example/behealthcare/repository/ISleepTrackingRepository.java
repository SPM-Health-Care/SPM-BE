package org.example.behealthcare.repository;

import org.example.behealthcare.entity.SleepTracking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ISleepTrackingRepository extends JpaRepository<SleepTracking, Long> {
    void deleteBySleepId(Integer sleepId);

    void deleteByUser_UserId(Integer userUserId);

    List<SleepTracking> findByUser_UserId(Integer userUserId);
}
