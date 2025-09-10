package org.example.behealthcare.repository;

import org.example.behealthcare.entity.MoodTracking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MoodTrackingRepository extends JpaRepository<MoodTracking, Long> {
}
