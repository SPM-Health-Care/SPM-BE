package org.example.behealthcare.entity;
import java.util.Set;
import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "roles")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, unique = true)
    private String roleName;

    String description;

    @ManyToMany
    Set<Permission> permissions;

    @ManyToMany(mappedBy = "roles")
    private Set<User> users;
}
