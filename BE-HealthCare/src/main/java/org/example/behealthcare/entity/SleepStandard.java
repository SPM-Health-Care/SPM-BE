package org.example.behealthcare.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "sleep_standards")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SleepStandard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer standardId;

    private Integer minHours;
    private Integer maxHours;
}