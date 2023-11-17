package ru.coffee.studentservicespring.repository;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.coffee.studentservicespring.domain.dto.StudentDtoWithAverageScore;
import ru.coffee.studentservicespring.domain.model.Student;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long>, CommandWithStudentRepository {

    @Query("""
           select new ru.coffee.studentservicespring.domain.dto.StudentDtoWithAverageScore 
           (s.name , s.lastName , s.classroom.classroom,
           (sp.geometry + sp.informatics + sp.literature + sp.rus + sp.mathematics + sp.physic) / 6) 
           from Student s 
           join StudentProgress sp 
           on s.sp.id = sp.id 
           where s.classroom.classroom = :classroom
           """)
    List<StudentDtoWithAverageScore> getAverageMarkOfStudents(@Param("classroom") int classroom);

}
