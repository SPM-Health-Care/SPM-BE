package org.example.behealthcare.service.imp;

import org.example.behealthcare.dto.ReminderCreateDTO;
import org.example.behealthcare.dto.ReminderDTO;
import org.example.behealthcare.entity.Reminder;
import org.example.behealthcare.entity.ReminderType;
import org.example.behealthcare.entity.User;
import org.example.behealthcare.repository.IReminderRepository;
import org.example.behealthcare.repository.IReminderTypeRepository;
import org.example.behealthcare.repository.UserRepository;
import org.example.behealthcare.service.IReminderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReminderService implements IReminderService {
    @Autowired
    private IReminderRepository IReminderRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private IReminderTypeRepository IReminderTypeRepository;

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

    @Override
    public Reminder update(Integer reminderId, Integer userId, ReminderDTO dto) {
        Reminder reminder = IReminderRepository.findByReminderIdAndUserId(reminderId, userId)
                .orElseThrow(()-> new RuntimeException("Reminder not found"));
        if (dto.getStatus() != null) reminder.setStatus(dto.getStatus());
        return IReminderRepository.save(reminder);
    }

    @Override
    public Reminder create(ReminderCreateDTO dto) {
        User user = userRepository.findById(dto.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        ReminderType reminderType = IReminderTypeRepository.findById(dto.getTypeId())
                .orElseThrow(() -> new RuntimeException("Reminder type not found"));

        Reminder reminder = Reminder.builder()
                .user(user)
                .reminderType(reminderType)
                .status(dto.getStatus())
                .build();
        return IReminderRepository.save(reminder);
    }
}
