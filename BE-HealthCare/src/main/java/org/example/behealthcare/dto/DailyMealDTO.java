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
public class DailyMealDTO {
    private Integer id;

    @NotNull(message = "User ID không được để trống")
    private Integer userId;

    @NotNull(message = "Food ID không được để trống")
    private Integer foodId;
}
