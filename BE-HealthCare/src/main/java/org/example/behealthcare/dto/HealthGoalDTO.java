package org.example.behealthcare.dto;
import jakarta.validation.constraints.*;
import lombok.*;
import org.example.behealthcare.entity.HealthGoal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HealthGoalDTO {
    private Integer id;

    @NotNull(message = "User ID không được để trống")
    private Integer userId;

    @NotNull(message = "Chỉ số cân nặng không được để trống" )
    @Min(value = 0, message = "Chỉ số cân nặng phải lớn hơn hoặc bằng 0")
    private Double weightGoal;

    @NotNull(message = "Chỉ số mục tiêu không được để trống")
    private Double bpGoal;

    public HealthGoalDTO(HealthGoal goal) {
        this.id = goal.getGoalId();
        this.userId = goal.getUser().getUserId();
        this.weightGoal = goal.getWeightGoal();
        this.bpGoal = goal.getBpGoal();
    }
}
