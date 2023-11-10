package ru.coffee.studentservicespring.domain.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "student")
public class Student {

    @Id
    @Column(name = "student_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "age")
    private int age;

    @PrimaryKeyJoinColumn
    @OneToOne(cascade = CascadeType.ALL)
    @Transient
    private Classroom classroom;

    @PrimaryKeyJoinColumn
    @OneToOne
    private StudentProgress sp;

}
