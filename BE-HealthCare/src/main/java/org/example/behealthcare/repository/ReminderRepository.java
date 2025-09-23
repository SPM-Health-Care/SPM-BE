package org.example.behealthcare.repository;

import org.example.behealthcare.entity.Reminder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReminderRepository extends JpaRepository<Reminder, Integer> {
    void deleteByReminderId(Integer reminderId);

    void deleteByUser_UserId(Integer userId);

    List<Reminder> findByUser_UserId(Integer userId);
}
