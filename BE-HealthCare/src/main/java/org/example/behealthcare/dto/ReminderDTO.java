package org.example.behealthcare.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.behealthcare.entity.Reminder;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReminderDTO {
    private Integer reminderId;

    @NotNull(message = "User ID không được để trống")
    private Integer userId;

    @NotNull(message = "Loại nhắc nhở không được để trống")
    private Integer typeId;

    @NotNull(message = "Trạng thái không được để trống")
    private String status;

    @NotBlank(message = "Tên loại nhắc nhở không được để trống")
    private String typeName;

    @NotBlank(message = "Username không được để trống")
    @Size(min = 3, max = 30, message = "Username phải từ 3 đến 30 ký tự")
    private String username;

    public ReminderDTO(Integer reminderId, String status, Integer userId, String username,
                       Integer typeId, String typeName) {
        this.reminderId = reminderId;
        this.status = status;
        this.userId = userId;
        this.username = username;
        this.typeId = typeId;
        this.typeName = typeName;
    }

    public ReminderDTO(Reminder updated) {
        this.reminderId = updated.getReminderId();
        this.status = updated.getStatus();
        this.userId = updated.getUser().getUserId();
    }
}

