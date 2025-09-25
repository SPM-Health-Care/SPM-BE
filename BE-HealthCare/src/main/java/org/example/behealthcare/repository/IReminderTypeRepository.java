package org.example.behealthcare.repository;

import org.example.behealthcare.entity.ReminderType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IReminderTypeRepository extends JpaRepository<ReminderType, Long> {
    List<ReminderType> findByTypeId(Integer typeId);
}
