package ru.coffee.studentservicespring.service;

import org.springframework.stereotype.Service;
import ru.coffee.studentservicespring.domain.dto.StudentDtoForAdding;
import ru.coffee.studentservicespring.domain.dto.StudentDtoWithAverageScore;
import ru.coffee.studentservicespring.domain.dto.StudentDtoToChangeMark;

import java.util.List;

@Service
public interface StudentService {

    void addStudent(StudentDtoForAdding student);

    List<StudentDtoWithAverageScore> getAverageScore(int classroom);

    StudentDtoToChangeMark changeScore(StudentDtoToChangeMark student);

}
