package org.example.behealthcare.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "health_goals")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class HealthGoal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer goalId;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    private Double weightGoal;
    private Double bpGoal;
}
