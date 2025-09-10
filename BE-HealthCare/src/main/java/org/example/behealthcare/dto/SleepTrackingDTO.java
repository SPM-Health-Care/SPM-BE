package org.example.behealthcare.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SleepTrackingDTO {
    private Integer id;

    @NotNull(message = "User ID không được để trống")
    private Integer userId;

    @NotBlank(message = "Thời gian đi ngủ không được để trống")
    private String sleepTime;

    @NotBlank(message = "Thời gian thức dậy không được để trống")
    private String wakeTime;

    private Integer standardId;
}

