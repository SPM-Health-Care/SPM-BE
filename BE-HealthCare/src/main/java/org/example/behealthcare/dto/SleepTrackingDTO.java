package org.example.behealthcare.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SleepTrackingDTO {
    private Integer id;

    @NotNull(message = "User ID không được để trống")
    private Integer userId;

    @NotBlank(message = "Thời gian đi ngủ không được để trống")
    private LocalTime sleepTime;

    @NotBlank(message = "Thời gian thức dậy không được để trống")
    private LocalTime wakeTime;

    @NotNull(message = "Ngày ghi nhận không được để trống")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @PastOrPresent(message = "Ngày ghi nhận không được sau ngày hiện tại")
    private LocalDate recordedAt;
}

