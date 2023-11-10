package ru.coffee.studentservicespring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.coffee.studentservicespring.domain.model.Classroom;

public interface ClassroomRepository extends JpaRepository<Classroom, Long> {
}
