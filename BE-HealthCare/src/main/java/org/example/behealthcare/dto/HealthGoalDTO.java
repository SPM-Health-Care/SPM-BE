package org.example.behealthcare.dto;
import jakarta.validation.constraints.*;
import lombok.*;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HealthGoalDTO {
    private Integer id;

    @NotNull(message = "User ID không được để trống")
    private Integer userId;

    private Double weightGoal;
    private Double bpGoal;
}
