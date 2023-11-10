package ru.coffee.studentservicespring.repository;

import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import ru.coffee.studentservicespring.domain.dto.StudentDtoToChangeScore;
import ru.coffee.studentservicespring.domain.dto.StudentDtoWithAverageScore;
import ru.coffee.studentservicespring.domain.model.Student;

import java.util.List;

public interface StudentJpaRepository extends JpaRepository<Student, Long> {

    @Query(value = "SELECT s.name, s.last_name, s.class_id, (sp.rus + sp.literature + sp.mathematics + " +
                   "sp.geometry + sp.informatics + sp.physic) / 6 AS average " +
                   "FROM student s " +
                   "JOIN student_progress sp ON s.sp_id = sp.sp_id " +
                   "WHERE s.class_id = :classroom", nativeQuery = true)
    List<StudentDtoWithAverageScore> getAverageScore(int classroom);


}
