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
public class HealthMetricCreateDTO {
    private Integer userId;
    private Double weight;
    private Double bloodPressure;
    private Double heartRate;
    private LocalDate recordedAt;
    private Integer thresholdId;
}

