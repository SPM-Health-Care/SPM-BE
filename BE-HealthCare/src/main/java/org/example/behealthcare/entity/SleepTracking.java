package org.example.behealthcare.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "sleep_tracking")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SleepTracking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer sleepId;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    private String sleepTime;
    private String wakeTime;

    @ManyToOne
    @JoinColumn(name = "standard_id", nullable = false)
    private SleepStandard sleepStandard;
}
