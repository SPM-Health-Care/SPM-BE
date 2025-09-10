package org.example.behealthcare.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReminderTypeDTO {
    private Integer id;

    @NotBlank(message = "Tên loại nhắc nhở không được để trống")
    private String typeName;
}

