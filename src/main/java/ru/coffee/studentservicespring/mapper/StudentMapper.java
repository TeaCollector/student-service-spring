package ru.coffee.studentservicespring.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.coffee.studentservicespring.domain.dto.StudentDtoForAdding;
import ru.coffee.studentservicespring.domain.dto.StudentDtoToChangeScore;
import ru.coffee.studentservicespring.domain.model.Classroom;
import ru.coffee.studentservicespring.domain.model.Student;

@Mapper(componentModel = "spring")
public interface StudentMapper {


    default Student studentDtoToStudent(StudentDtoForAdding studentDtoForAdding) {
        Student student = new Student();
        student.setName(studentDtoForAdding.getName());
        student.setLastName(studentDtoForAdding.getLastName());
        student.setAge(studentDtoForAdding.getAge());
        Classroom classroom = new Classroom();
        classroom.setClassroom(studentDtoForAdding.getClassroom());
        student.setClassroom(classroom);
        return student;
    }

//    default Student studentChangeScoreToStudent(StudentDtoToChangeScore studentForChangeScore) {
//        Student student = new Student();
//        student.setName(studentForChangeScore.getName());
//        student.setLastName(studentForChangeScore.getLastName());
//
//        Classroom classroom = new Classroom();
//        classroom.setClassroom(studentForChangeScore.getClassroom());
//        student.setClassroom(classroom);
//        return student;
//    }

}
