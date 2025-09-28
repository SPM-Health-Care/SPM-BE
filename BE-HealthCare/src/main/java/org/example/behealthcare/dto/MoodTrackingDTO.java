package org.example.behealthcare.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.behealthcare.entity.MoodTracking;
import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MoodTrackingDTO {
    private Integer moodId;

    @NotNull(message = "User ID không được để trống")
    private Integer userId;

    @NotNull(message = "Tâm trạng không được để trống")
    private String mood;

    @NotNull(message = "Ngày ghi nhận không được để trống")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @PastOrPresent(message = "Ngày ghi nhận không được sau ngày hiện tại")
    private LocalDate recordedAt;

    @NotNull(message = "Mức độ căng thẳng không được để trống")
    @Range(min = 1, max = 5, message = "Mức độ căng thẳng phải từ 1 đến 5")
    private Integer stressLevel;

    public MoodTrackingDTO(String mood, Integer moodId, LocalDate recordedAt, Integer stressLevel, Integer userId) {
        this.mood = mood;
        this.moodId = moodId;
        this.recordedAt = recordedAt;
        this.stressLevel = stressLevel;
        this.userId = userId;
    }

    public MoodTrackingDTO(MoodTracking updated) {
        this.mood = updated.getMood();
        this.stressLevel = updated.getStressLevel();
    }
}

