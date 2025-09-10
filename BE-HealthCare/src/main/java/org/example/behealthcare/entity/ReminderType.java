package org.example.behealthcare.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "reminder_types")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ReminderType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer typeId;

    @Column(nullable = false, unique = true)
    private String typeName;
}
