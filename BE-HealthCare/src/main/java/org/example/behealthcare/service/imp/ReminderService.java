package org.example.behealthcare.service.imp;

import org.example.behealthcare.dto.ReminderDTO;
import org.example.behealthcare.entity.Reminder;
import org.example.behealthcare.repository.IReminderRepository;
import org.example.behealthcare.service.IReminderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReminderService implements IReminderService {
    @Autowired
    private IReminderRepository IReminderRepository;
    @Override
    public void deleteByReminderId(Integer reminderId) {
        IReminderRepository.deleteByReminderId(reminderId);
    }

    @Override
    public void deleteByUser_UserId(Integer userId) {
        IReminderRepository.deleteByUser_UserId(userId);
    }

    @Override
    public List<ReminderDTO> findByUser_UserId(Integer userId) {
        return IReminderRepository.findAllByUser_UserId(userId);
    }

    @Override
    public Reminder save(Reminder reminder) {
        return IReminderRepository.save(reminder);
    }
}
