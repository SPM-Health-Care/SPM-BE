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
public class MoodTrackingDTO {
    private Integer id;

    @NotNull(message = "User ID không được để trống")
    private Integer userId;

    private String mood;
    private Integer stressLevel;
}

