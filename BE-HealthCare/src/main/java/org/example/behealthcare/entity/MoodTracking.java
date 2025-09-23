package org.example.behealthcare.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "mood_tracking")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MoodTracking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer moodId;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    private String mood;
    private Integer stressLevel;
    private LocalDate recordedAt;
}

