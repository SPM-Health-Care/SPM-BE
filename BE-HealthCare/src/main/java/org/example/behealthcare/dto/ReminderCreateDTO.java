package org.example.behealthcare.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReminderCreateDTO {
    private Integer userId;
    private Integer typeId;
    private String status;
}
