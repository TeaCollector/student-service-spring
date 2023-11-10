package ru.coffee.studentservicespring.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.coffee.studentservicespring.domain.dto.StudentDtoForAdding;
import ru.coffee.studentservicespring.domain.dto.StudentDtoWithAverageScore;
import ru.coffee.studentservicespring.domain.dto.StudentDtoToChangeScore;
import ru.coffee.studentservicespring.domain.model.Classroom;
import ru.coffee.studentservicespring.domain.model.Student;
import ru.coffee.studentservicespring.domain.model.StudentProgress;
import ru.coffee.studentservicespring.mapper.StudentMapper;
import ru.coffee.studentservicespring.repository.ClassroomRepository;
import ru.coffee.studentservicespring.repository.StudentJpaRepository;
import ru.coffee.studentservicespring.repository.StudentProgressRepository;
import ru.coffee.studentservicespring.service.StudentService;

import java.util.List;

@Service
@Slf4j
public class StudentServiceImpl implements StudentService {

    private ClassroomRepository classroomRepository;
    private StudentProgressRepository studentProgressRepository;
    private StudentJpaRepository studentRepository;
    private StudentMapper mapper;

    public StudentServiceImpl(ClassroomRepository classroomRepository, StudentProgressRepository studentProgressRepository,
                              StudentJpaRepository studentRepository,
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
        System.out.println(st.getClassroom().getClassroom());
        Classroom classroom = classroomRepository.getReferenceById((long) st.getClassroom().getClassroom());
        log.warn(classroom.toString());
        st.setClassroom(classroom);
        log.warn(st.toString());
        studentProgressRepository.save(new StudentProgress());
        studentRepository.save(st);
    }

    @Override
    public List<StudentDtoWithAverageScore> getAverageScore(int classroom) {
        return studentRepository.getAverageScore(classroom);
    }

    @Override
    public void changeScore(StudentDtoToChangeScore studentForChangeScore) {
//        Student student = mapper.studentChangeScoreToStudent(studentForChangeScore);
        log.info("WE ARE HERE!!!");
        studentProgressRepository.changeScore(studentForChangeScore.getScore(), studentForChangeScore.getName(),
                studentForChangeScore.getLastName(), studentForChangeScore.getClassroom());
    }
}
