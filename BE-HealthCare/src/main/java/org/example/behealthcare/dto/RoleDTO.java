package org.example.behealthcare.dto;

import jakarta.validation.constraints.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RoleDTO {
    private Integer id;

    @NotBlank(message = "Tên role không được để trống")
    private String roleName;
}

