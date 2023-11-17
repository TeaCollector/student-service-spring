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

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private final ClassroomRepository classroomRepository;
    private final StudentProgressRepository studentProgressRepository;
    private final StudentRepository studentRepository;
    private final StudentMapper mapper;

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
        StudentProgress studentProgress = studentProgressRepository.save(new StudentProgress());
        st.setClassroom(classroom);
        st.setSp(studentProgress);
        studentRepository.save(st);
    }

    @Override
    public List<StudentDtoWithAverageScore> getAverageScore(int classroom) {
        return studentRepository.getAverageMarkOfStudents(classroom);
    }

    @Transactional
    @Override
    public StudentDtoToChangeMark changeScore(StudentDtoToChangeMark studentForChangeMark) {
        return studentRepository.changeScore(studentForChangeMark);
    }
}
