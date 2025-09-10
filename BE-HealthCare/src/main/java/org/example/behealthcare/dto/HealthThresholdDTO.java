package org.example.behealthcare.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HealthThresholdDTO {
    private Integer id;

    @NotBlank(message = "Loại chỉ số không được để trống")
    private String metricType;

    private Double minValue;
    private Double maxValue;
}

