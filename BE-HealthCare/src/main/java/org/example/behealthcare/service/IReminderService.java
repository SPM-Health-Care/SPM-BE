package org.example.behealthcare.service;

import org.example.behealthcare.entity.Reminder;

import java.util.List;

public interface IReminderService {
    void deleteByReminderId(Integer reminderId);

    void deleteByUser_UserId(Integer userId);

    List<Reminder> findByUser_UserId(Integer userId);

    Reminder save(Reminder reminder);
}
