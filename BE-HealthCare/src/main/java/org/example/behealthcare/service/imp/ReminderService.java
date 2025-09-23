package org.example.behealthcare.service.imp;

import org.example.behealthcare.entity.Reminder;
import org.example.behealthcare.repository.ReminderRepository;
import org.example.behealthcare.service.IReminderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReminderService implements IReminderService {
    @Autowired
    private ReminderRepository reminderRepository;
    @Override
    public void deleteByReminderId(Integer reminderId) {
        reminderRepository.deleteByReminderId(reminderId);
    }

    @Override
    public void deleteByUser_UserId(Integer userId) {
        reminderRepository.deleteByUser_UserId(userId);
    }

    @Override
    public List<Reminder> findByUser_UserId(Integer userId) {
        return reminderRepository.findByUser_UserId(userId);
    }

    @Override
    public Reminder save(Reminder reminder) {
        return reminderRepository.save(reminder);
    }
}
