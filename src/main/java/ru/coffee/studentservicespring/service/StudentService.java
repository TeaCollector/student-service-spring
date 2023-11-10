package ru.coffee.studentservicespring.service;

import ru.coffee.studentservicespring.domain.dto.StudentDtoForAdding;
import ru.coffee.studentservicespring.domain.dto.StudentDtoWithAverageScore;
import ru.coffee.studentservicespring.domain.dto.StudentDtoToChangeScore;
import ru.coffee.studentservicespring.domain.model.Student;

import java.util.List;


public interface StudentService {

    void addStudent(StudentDtoForAdding student);

    List<StudentDtoWithAverageScore> getAverageScore(int classroom);

    void changeScore(StudentDtoToChangeScore student);

}
