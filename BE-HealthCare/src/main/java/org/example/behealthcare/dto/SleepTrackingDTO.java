package org.example.behealthcare.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.behealthcare.entity.SleepTracking;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SleepTrackingDTO {
    private Integer sleepId;

    @NotNull(message = "User ID không được để trống")
    private Integer userId;

    @NotBlank(message = "Username không được để trống")
    @Size(min = 3, max = 30, message = "Username phải từ 3 đến 30 ký tự")
    private String username;

    @NotBlank(message = "Thời gian đi ngủ không được để trống")
    private String sleepTime;

    @NotBlank(message = "Thời gian thức dậy không được để trống")
    private String wakeTime;

    @NotNull(message = "Ngày ghi nhận không được để trống")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @PastOrPresent(message = "Ngày ghi nhận không được sau ngày hiện tại")
    private LocalDate recordedAt;

    public SleepTrackingDTO(LocalDate recordedAt, Integer sleepId, String sleepTime, Integer userId, String username, String wakeTime) {
        this.recordedAt = recordedAt;
        this.sleepId = sleepId;
        this.sleepTime = sleepTime;
        this.userId = userId;
        this.username = username;
        this.wakeTime = wakeTime;
    }

    public SleepTrackingDTO(SleepTracking updated) {
        this.sleepTime = updated.getSleepTime();
        this.wakeTime = updated.getWakeTime();
        this.recordedAt = updated.getRecordedAt();
    }
}

