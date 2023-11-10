package ru.coffee.studentservicespring.repository;

import ru.coffee.studentservicespring.domain.dto.StudentDtoForAdding;
import ru.coffee.studentservicespring.domain.dto.StudentDtoWithAverageScore;
import ru.coffee.studentservicespring.domain.dto.StudentDtoToChangeScore;

import java.util.List;

public interface StudentRepository {

    void addStudent(StudentDtoForAdding student);

    List<StudentDtoWithAverageScore> getAverageScore(int classroom);

    void changeScore(StudentDtoToChangeScore student);
}
