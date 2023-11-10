package ru.coffee.studentservicespring.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.coffee.studentservicespring.domain.dto.StudentDtoForAdding;
import ru.coffee.studentservicespring.domain.dto.StudentDtoWithAverageScore;
import ru.coffee.studentservicespring.domain.dto.StudentDtoToChangeScore;
import ru.coffee.studentservicespring.domain.model.Student;
import ru.coffee.studentservicespring.service.StudentService;

import java.util.List;

@RestController
@RequestMapping("students")
public class StudentController {

    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public ResponseEntity<List<StudentDtoWithAverageScore>> getStudentWithAverage(@RequestParam(name = "class") int classroom) {
        List<StudentDtoWithAverageScore> listStudents = studentService.getAverageScore(classroom);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(listStudents);
    }

    @PutMapping
    public ResponseEntity<String> changeScore(@RequestBody StudentDtoToChangeScore studentDto) {
        studentService.changeScore(studentDto);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Update");
    }

    @PostMapping
    public ResponseEntity<String> addStudent(@RequestBody StudentDtoForAdding student) {
        studentService.addStudent(student);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
