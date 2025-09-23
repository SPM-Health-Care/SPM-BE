package org.example.behealthcare.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
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
public class HealthThresholdDTO {
    private Integer id;

    @NotNull(message = "Loại chỉ số không được để trống")
    private String metricType;

    @NotNull(message = "Giá trị tối thiểu không được để trống")
    @Min(value = 0, message = "Giá trị tối thiểu phải lớn hơn hoặc bằng 0")
    private Double minValue;

    @NotNull(message = "Giá trị tối đa không được để trống")
    @Max(value = 100, message =  "Giá trị tối đa phải nhỏ hơn hoặc bằng 100")
    private Double maxValue;
}

