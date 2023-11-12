package ru.coffee.studentservicespring.domain.model;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "lesson")
public class Lesson implements Serializable {

    @Id
    @Column(name = "lesson_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "lesson_name")
    private String lessonName;
}
