package ru.coffee.studentservicespring.initdb;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Component;
import ru.coffee.studentservicespring.domain.model.Classroom;
import ru.coffee.studentservicespring.domain.model.Student;
import ru.coffee.studentservicespring.domain.model.StudentProgress;
import ru.coffee.studentservicespring.repository.StudentProgressRepository;
import ru.coffee.studentservicespring.repository.StudentRepository;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class PopulateDB {

    private final StudentProgressRepository studentProgressRepository;
    private final StudentRepository studentRepository;


    public PopulateDB(StudentProgressRepository studentProgressRepository, StudentRepository studentRepository) {
        this.studentProgressRepository = studentProgressRepository;
        this.studentRepository = studentRepository;
    }

//    @EventListener(ApplicationReadyEvent.class)
    public List<Student> csvToStudent() {
        try (BufferedReader fileReader = new BufferedReader(new FileReader("src/main/resources/students.csv"));
             CSVParser csvParser = CSVParser.parse(fileReader, CSVFormat.Builder
                     .create()
                     .setDelimiter(";")
                     .setHeader("family", "name", "age", "group", "physics", "mathematics", "rus", "literature", "geometry", "informatics")
                     .setSkipHeaderRecord(true)
                     .build())) {

            List<Student> studentList = new ArrayList<>();
            List<StudentProgress> studentProgressList = new ArrayList<>();


            for (CSVRecord csvRecord : csvParser) {

                Student student = new Student();
                student.setName(csvRecord.get("name"));
                student.setLastName(csvRecord.get("family"));
                student.setAge(Integer.parseInt(csvRecord.get("age")));
                Classroom classroom = new Classroom();
                classroom.setClassroom(Integer.parseInt(csvRecord.get("group")));
                student.setClassroom(classroom);

                StudentProgress studentProgress = new StudentProgress();
                studentProgress.setGeometry(Integer.parseInt(csvRecord.get("geometry")));
                studentProgress.setInformatics(Integer.parseInt(csvRecord.get("informatics")));
                studentProgress.setLiterature(Integer.parseInt(csvRecord.get("literature")));
                studentProgress.setPhysic(Integer.parseInt(csvRecord.get("physics")));
                studentProgress.setMathematics(Integer.parseInt(csvRecord.get("mathematics")));
                studentProgress.setRus(Integer.parseInt(csvRecord.get("rus")));

                studentProgressList.add(studentProgress);
                studentList.add(student);
            }

            studentProgressRepository.saveAll(studentProgressList);
            studentRepository.saveAll(studentList);

            return studentList;
        } catch (IOException ioe) {
            throw new RuntimeException("fail to parse CSV file: " + ioe.getMessage());
        }
    }
}
