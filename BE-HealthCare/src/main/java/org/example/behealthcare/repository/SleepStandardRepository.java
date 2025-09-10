package org.example.behealthcare.repository;

import org.example.behealthcare.entity.SleepStandard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SleepStandardRepository extends JpaRepository<SleepStandard, Long> {
}
