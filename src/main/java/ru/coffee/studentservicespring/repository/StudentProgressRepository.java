package ru.coffee.studentservicespring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.coffee.studentservicespring.domain.model.StudentProgress;

public interface StudentProgressRepository extends JpaRepository<StudentProgress, Long> {
}
