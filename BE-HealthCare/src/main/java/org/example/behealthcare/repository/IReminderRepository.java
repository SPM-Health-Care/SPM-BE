package org.example.behealthcare.repository;

import org.example.behealthcare.dto.ReminderDTO;
import org.example.behealthcare.entity.Reminder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IReminderRepository extends JpaRepository<Reminder, Integer> {
    void deleteByReminderId(Integer reminderId);

    void deleteByUser_UserId(Integer userId);

    @Query("SELECT new org.example.behealthcare.dto.ReminderDTO( " +
            "r.reminderId, r.status, u.userId, u.username, t.typeId, t.typeName) " +
            "FROM Reminder r " +
            "JOIN r.user u " +
            "JOIN r.reminderType t " +
            "WHERE u.userId = :userId")
    List<ReminderDTO> findAllByUser_UserId(@Param("userId") Integer userId);

}
