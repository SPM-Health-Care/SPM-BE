package org.example.behealthcare.dto;

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
public class ReportDTO {
    private Integer id;

    @NotNull(message = "User ID không được để trống")
    private Integer userId;

    @NotBlank(message = "Loại báo cáo không được để trống")
    private String reportType;
}

