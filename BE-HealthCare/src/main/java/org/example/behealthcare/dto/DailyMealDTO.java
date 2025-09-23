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
public class DailyMealDTO {
    private Integer mealId;

    @NotNull(message = "User ID không được để trống")
    private Integer userId;

    @NotNull(message = "Food ID không được để trống")
    private Integer foodId;

    @NotNull(message = "Calories không được để trống")
    @Min(value = 0, message = "Calories phải là số nguyên dương hoặc bằng 0")
    private Integer calories;

    @NotNull(message = "Ngày ghi nhận không được để trống")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @PastOrPresent(message = "Ngày ghi nhận không được sau ngày hiện tại")
    private LocalDate recordedAt;


}
