package ru.coffee.studentservicespring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.coffee.studentservicespring.domain.model.StudentProgress;

public interface StudentProgressRepository extends JpaRepository<StudentProgress, Long> {

    @Modifying
    @Query(value = "UPDATE student_progress SET rus = :score WHERE sp_id = (SELECT s.sp_id " +
                   "FROM student s " +
                   "WHERE s.name = :name " +
                   "AND s.last_name = :lastName " +
                   "AND s.class_id = :classroom)", nativeQuery = true)
    void changeScore(@Param("score") int score, @Param("name") String name,
                     @Param("lastName") String lastName, @Param("classroom") int classroom);
}
