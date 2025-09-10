package org.example.behealthcare.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "nutrition_database")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NutritionDatabase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer foodId;

    @Column(nullable = false)
    private String foodName;

    private Double calories;
}
