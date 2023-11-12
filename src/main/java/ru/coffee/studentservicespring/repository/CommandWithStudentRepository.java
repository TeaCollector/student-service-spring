package ru.coffee.studentservicespring.repository;

import ru.coffee.studentservicespring.domain.dto.StudentDtoWithAverageScore;
import ru.coffee.studentservicespring.domain.dto.StudentDtoToChangeMark;
import ru.coffee.studentservicespring.domain.model.Student;

import java.util.List;

public interface CommandWithStudentRepository {

    StudentDtoToChangeMark changeScore(StudentDtoToChangeMark student);
}
