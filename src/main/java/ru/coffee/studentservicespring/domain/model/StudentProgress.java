package ru.coffee.studentservicespring.domain.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity(name = "student_progress")
@Table(name = "student_progress")
public class StudentProgress {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sp_id")
    private Long id;

    @Column(name = "physic")
    private int physic;

    @Column(name = "mathematics")
    private int mathematics;

    @Column(name = "rus")
    private int rus;

    @Column(name = "literature")
    private int literature;

    @Column(name = "geometry")
    private int geometry;

    @Column(name = "informatics")
    private int informatics;
}
