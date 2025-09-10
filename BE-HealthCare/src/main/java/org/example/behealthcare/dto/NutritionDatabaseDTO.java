package org.example.behealthcare.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class NutritionDatabaseDTO {
    private Integer id;

    @NotBlank(message = "Tên món ăn không được để trống")
    private String foodName;

    @Positive(message = "Calories phải lớn hơn 0")
    private Double calories;
}
