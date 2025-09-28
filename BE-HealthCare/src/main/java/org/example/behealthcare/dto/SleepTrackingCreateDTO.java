package org.example.behealthcare.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SleepTrackingCreateDTO {
    private Integer userId;
    private String sleepTime;
    private String wakeTime;
    private LocalDate recordedAt;
}
