package org.example.behealthcare.repository;

import org.example.behealthcare.dto.SleepTrackingDTO;
import org.example.behealthcare.entity.SleepTracking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ISleepTrackingRepository extends JpaRepository<SleepTracking, Long> {
    void deleteBySleepId(Integer sleepId);

    void deleteByUser_UserId(Integer userUserId);

    @Query("SELECT new org.example.behealthcare.dto.SleepTrackingDTO( " +
            "s.recordedAt, s.sleepId, s.sleepTime, u.userId, u.username, s.wakeTime) " +
            "FROM SleepTracking s " +
            "JOIN s.user u " +
            "WHERE u.userId = :userId")
    List<SleepTrackingDTO> findByUser_UserId(@Param("userId") Integer userId);

}
