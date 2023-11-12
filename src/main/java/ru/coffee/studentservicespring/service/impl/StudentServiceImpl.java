package ru.coffee.studentservicespring.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.coffee.studentservicespring.domain.dto.StudentDtoForAdding;
import ru.coffee.studentservicespring.domain.dto.StudentDtoWithAverageScore;
import ru.coffee.studentservicespring.domain.dto.StudentDtoToChangeMark;
import ru.coffee.studentservicespring.domain.model.Classroom;
import ru.coffee.studentservicespring.domain.model.Student;
import ru.coffee.studentservicespring.domain.model.StudentProgress;
import ru.coffee.studentservicespring.mapper.StudentMapper;
import ru.coffee.studentservicespring.repository.ClassroomRepository;
import ru.coffee.studentservicespring.repository.StudentRepository;
import ru.coffee.studentservicespring.repository.StudentProgressRepository;
import ru.coffee.studentservicespring.service.StudentService;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class StudentServiceImpl implements StudentService {

    private ClassroomRepository classroomRepository;
    private StudentProgressRepository studentProgressRepository;
    private StudentRepository studentRepository;
    private StudentMapper mapper;

    public StudentServiceImpl(ClassroomRepository classroomRepository, StudentProgressRepository studentProgressRepository,
                              StudentRepository studentRepository,
                              StudentMapper mapper) {
        this.classroomRepository = classroomRepository;
        this.studentProgressRepository = studentProgressRepository;
        this.studentRepository = studentRepository;
        this.mapper = mapper;
    }

    @Transactional
    @Override
    public void addStudent(StudentDtoForAdding student) {
        Student st = mapper.studentDtoToStudent(student);
        Classroom classroom = classroomRepository.getReferenceById((long) st.getClassroom().getClassroom());
        st.setClassroom(classroom);
        studentProgressRepository.save(new StudentProgress());
        studentRepository.save(st);
    }

    @Override
    public List<Object> getAverageScore(int classroom) {
        return studentRepository.getAverageMarkOfStudents(classroom);
//        log.info("what that: {}", averageMarkOfStudents.get(0).getClass().getSimpleName());
//
//        Object[] str = (Object[]) averageMarkOfStudents.get(0);
//        log.info("what that: {}", str);
//
//        List<StudentDtoWithAverageScore> listStudentDtoWithAverageScores = new ArrayList<>();
//        for (Object obj : averageMarkOfStudents) {
//            log.info("Just Object: {}", obj);
//            StudentDtoWithAverageScore studentDtoWithAverageScore = mapper.objToStudentDtoWithAverageScore(obj);
//            log.info("Student DTO: {}", studentDtoWithAverageScore.toString());
//            listStudentDtoWithAverageScores.add(studentDtoWithAverageScore);
//        }
//        return listStudentDtoWithAverageScores;
    }

    @Transactional
    @Override
    public StudentDtoToChangeMark changeScore(StudentDtoToChangeMark studentForChangeMark) {
        return studentRepository.changeScore(studentForChangeMark);
    }
}
