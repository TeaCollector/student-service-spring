package ru.coffee.studentservicespring.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.coffee.studentservicespring.domain.dto.StudentDtoForAdding;
import ru.coffee.studentservicespring.domain.dto.StudentDtoWithAverageScore;
import ru.coffee.studentservicespring.domain.dto.StudentDtoToChangeMark;
import ru.coffee.studentservicespring.service.StudentService;

import java.util.List;

@RestController
@RequestMapping("students")
public class StudentController {

    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("class/{class}/avg_marks")
    public ResponseEntity<List<StudentDtoWithAverageScore>> getStudentWithAverage(@PathVariable(name = "class")
                                                                                      int classroom) {
        List<StudentDtoWithAverageScore> listStudents = studentService.getAverageScore(classroom);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(listStudents);
    }

    @PatchMapping("change_mark")
    public ResponseEntity<StudentDtoToChangeMark> changeScore(@RequestBody StudentDtoToChangeMark studentDto) {
        studentService.changeScore(studentDto);
        return ResponseEntity
                .status(HttpStatus.NO_CONTENT)
                .body(studentDto);
    }

    @PostMapping("add")
    public ResponseEntity<StudentDtoForAdding> addStudent(@RequestBody StudentDtoForAdding student) {
        studentService.addStudent(student);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(student);
    }
}
