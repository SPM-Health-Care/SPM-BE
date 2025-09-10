package org.example.behealthcare.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "health_thresholds")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class HealthThreshold {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer thresholdId;

    @Column(nullable = false, length = 50)
    private String metricType;

    private Double minValue;
    private Double maxValue;
}

