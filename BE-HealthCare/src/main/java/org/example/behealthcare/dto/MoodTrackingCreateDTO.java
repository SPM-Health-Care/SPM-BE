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
public class MoodTrackingCreateDTO {
    private Integer userId;
    private String mood;
    private LocalDate recordedAt;
    private Integer stressLevel;
}
