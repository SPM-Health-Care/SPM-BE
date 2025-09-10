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
public class SleepStandardDTO {
    private Integer id;

    @NotNull(message = "Số giờ tối thiểu không được để trống")
    private Integer minHours;

    @NotNull(message = "Số giờ tối đa không được để trống")
    private Integer maxHours;
}

