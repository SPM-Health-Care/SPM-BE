package org.example.behealthcare.dto;

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
    private Integer id;

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

    @NotNull(message = "Threshold ID không được để trống")
    private Integer thresholdId;

    @NotNull(message = "Ngày ghi nhận không được để trống")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @PastOrPresent(message = "Ngày ghi nhận không được sau ngày hiện tại")
    private LocalDate recordedAt;
}

