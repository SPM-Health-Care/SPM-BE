package org.example.behealthcare.repository;

import org.example.behealthcare.entity.ReminderType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReminderTypeRepository extends JpaRepository<ReminderType, Long> {
}
