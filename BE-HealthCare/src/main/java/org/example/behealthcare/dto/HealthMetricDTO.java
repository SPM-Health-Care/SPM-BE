package org.example.behealthcare.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HealthMetricDTO {
    private Integer id;

    @NotNull(message = "User ID không được để trống")
    private Integer userId;

    private Double weight;
    private Double bloodPressure;
    private Double heartRate;

    private Integer thresholdId;
}

