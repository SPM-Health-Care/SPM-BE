package org.example.behealthcare.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "health_metrics")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class HealthMetric {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer metricId;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    private Double weight;
    private Double bloodPressure;
    private Double heartRate;
}

