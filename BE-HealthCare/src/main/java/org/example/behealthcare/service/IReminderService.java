package org.example.behealthcare.service;

import org.example.behealthcare.dto.ReminderCreateDTO;
import org.example.behealthcare.dto.ReminderDTO;
import org.example.behealthcare.entity.Reminder;

import java.util.List;

public interface IReminderService {
    void deleteByReminderId(Integer reminderId);

    void deleteByUser_UserId(Integer userId);

    List<ReminderDTO> findByUser_UserId(Integer userId);

    Reminder save(Reminder reminder);

    Reminder update(Integer reminderId ,Integer userId, ReminderDTO dto);

    Reminder create(ReminderCreateDTO  dto);
}
