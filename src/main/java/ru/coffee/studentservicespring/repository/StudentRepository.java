package ru.coffee.studentservicespring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.coffee.studentservicespring.domain.dto.StudentDtoWithAverageScore;
import ru.coffee.studentservicespring.domain.model.Student;
import ru.coffee.studentservicespring.domain.model.StudentProgress;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long>, CommandWithStudentRepository {
    @Query("from Student")
    List<Student> getAllStudents();

    @Query("select s.name as name, s.lastName as lastName, s.classroom.classroom as classroom, " +
           "(sp.geometry + sp.informatics + sp.literature + sp.rus + sp.mathematics + sp.physic) / 6 as average " +
           "from Student s join StudentProgress sp on s.sp.id = sp.id where s.classroom.classroom = :classroom")
    List<Object> getAverageMarkOfStudents(@Param("classroom") int classroom);

//    @Query("update sp set :lesson = :score from Stude", )
//    void changeMark(@Param("lesson") String lesson, @Param("score") int score, );

}
