package ru.coffee.studentservicespring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.coffee.studentservicespring.domain.model.StudentProgress;

public interface StudentProgressRepository extends JpaRepository<StudentProgress, Long> {
}
