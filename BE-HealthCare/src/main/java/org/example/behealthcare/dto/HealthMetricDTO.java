package org.example.behealthcare.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HealthMetricDTO {
    private Integer metricId;

    @NotNull(message = "User ID không được để trống")
    private Integer userId;

    @NotNull(message = "Cân nặng không được để trống")
    @Min(value = 0, message = "Cân nặng phải lớn hơn hoặc bằng 0")
    private Double weight;

    @NotNull(message = "Huyết áp không được để trống")
    @Min(value = 0, message = "Huyết áp phải lớn hơn hoặc bằng 0")
    private Double bloodPressure;

    @NotNull(message = "Nhịp tim không được để trống")
    @Min(value = 0, message = "Nhịp tim phải lớn hơn hoặc bằng 0")
    private Double heartRate;

//    @NotNull(message = "Threshold ID không được để trống")
//    private Integer thresholdId;

    @NotNull(message = "Ngày ghi nhận không được để trống")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @PastOrPresent(message = "Ngày ghi nhận không được sau ngày hiện tại")
    private LocalDate recordedAt;

    @NotNull(message = "Loại chỉ số không được để trống")
    private String metricType;

    @NotNull(message = "Giá trị tối thiểu không được để trống")
    @Min(value = 0, message = "Giá trị tối thiểu phải lớn hơn hoặc bằng 0")
    private Double minValue;

    @NotNull(message = "Giá trị tối đa không được để trống")
    @Max(value = 100, message =  "Giá trị tối đa phải nhỏ hơn hoặc bằng 100")
    private Double maxValue;

    public HealthMetricDTO(Integer metricId,
                           Double bloodPressure,
                           Double heartRate,
                           Double weight,
                           LocalDate recordedAt,
//                           Integer thresholdId,
                           Double maxValue,
                           Double minValue,
                           String metricType) {
        this.metricId = metricId;
        this.bloodPressure = bloodPressure;
        this.heartRate = heartRate;
        this.weight = weight;
        this.recordedAt = recordedAt;
//        this.thresholdId = thresholdId;
        this.maxValue = maxValue;
        this.minValue = minValue;
        this.metricType = metricType;
    }
}

