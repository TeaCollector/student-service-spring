package ru.coffee.studentservicespring.repository;

import ru.coffee.studentservicespring.domain.dto.StudentDtoToChangeMark;

public interface CommandWithStudentRepository {

    StudentDtoToChangeMark changeScore(StudentDtoToChangeMark student);

}
