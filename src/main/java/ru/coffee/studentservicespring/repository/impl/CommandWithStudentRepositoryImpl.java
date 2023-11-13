package ru.coffee.studentservicespring.repository.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.*;
import ru.coffee.studentservicespring.domain.dto.StudentDtoToChangeMark;
import ru.coffee.studentservicespring.domain.model.Classroom;
import ru.coffee.studentservicespring.domain.model.Student;
import ru.coffee.studentservicespring.domain.model.StudentProgress;
import ru.coffee.studentservicespring.repository.CommandWithStudentRepository;

import java.util.List;

public class CommandWithStudentRepositoryImpl implements CommandWithStudentRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public StudentDtoToChangeMark changeScore(StudentDtoToChangeMark student) {

        Classroom classroom = entityManager
                .createQuery("select c " +
                             "from Classroom c " +
                             "where c.classroom = :classroom", Classroom.class)
                .setParameter("classroom", student.getClassroom()).getSingleResult();

        List<Student> studentToChangeMark = entityManager
                .createQuery("select s " +
                             "from Student s " +
                             "join s.classroom " +
                             "where s.classroom = :classroom " +
                             "and s.name = :name " +
                             "and s.lastName = :lastName", Student.class)
                .setParameter("classroom", classroom)
                .setParameter("name", student.getName())
                .setParameter("lastName", student.getLastName())
                .getResultList();

        CriteriaBuilder cbUpdate = entityManager.getCriteriaBuilder();
        CriteriaUpdate<StudentProgress> criteriaUpdate = cbUpdate.createCriteriaUpdate(StudentProgress.class);

        Root<StudentProgress> studentProgressRoot = criteriaUpdate.from(StudentProgress.class);
        criteriaUpdate.set(String.format(student.getLesson()), student.getScore());
        criteriaUpdate.where(cbUpdate.equal(studentProgressRoot.get("id"), studentToChangeMark.get(0).getId()));

        entityManager.createQuery(criteriaUpdate).executeUpdate();
        return student;
    }
}
