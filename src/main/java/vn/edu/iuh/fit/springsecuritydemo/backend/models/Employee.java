package vn.edu.iuh.fit.springsecuritydemo.backend.models;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "employee")
@Getter
@Setter
@ToString
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Enumerated(EnumType.ORDINAL)
    private State state;


    public Employee(String name, State state) {
        this.name = name;
        this.state = state;
    }

}
