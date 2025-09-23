package org.example.behealthcare.service.imp;

import org.example.behealthcare.entity.ReminderType;
import org.example.behealthcare.repository.ReminderTypeRepository;
import org.example.behealthcare.service.IReminderTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReminderTypeService implements IReminderTypeService {
    @Autowired
    private ReminderTypeRepository reminderTypeRepository;

    @Override
    public List<ReminderType> findByTypeId(Integer typeId) {
        return reminderTypeRepository.findByTypeId(typeId);
    }
}
