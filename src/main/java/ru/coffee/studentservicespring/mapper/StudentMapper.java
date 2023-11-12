package ru.coffee.studentservicespring.mapper;

import org.mapstruct.Mapper;
import ru.coffee.studentservicespring.domain.dto.StudentDtoForAdding;
import ru.coffee.studentservicespring.domain.dto.StudentDtoWithAverageScore;
import ru.coffee.studentservicespring.domain.model.Student;

@Mapper(componentModel = "spring")
public interface StudentMapper {

     Student studentDtoToStudent(StudentDtoForAdding studentDtoForAdding);

     StudentDtoWithAverageScore objToStudentDtoWithAverageScore(Object obj);

}
