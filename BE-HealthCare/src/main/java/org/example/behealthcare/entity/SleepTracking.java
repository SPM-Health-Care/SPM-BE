package org.example.behealthcare.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "sleep_tracking")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SleepTracking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer sleepId;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    private String sleepTime;
    private String wakeTime;
    private LocalDate recordedAt;
}
