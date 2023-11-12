package ru.coffee.studentservicespring.repository.impl;

import jakarta.persistence.DiscriminatorType;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.criteria.*;
import lombok.extern.slf4j.Slf4j;
import ru.coffee.studentservicespring.domain.dto.StudentDtoWithAverageScore;
import ru.coffee.studentservicespring.domain.dto.StudentDtoToChangeMark;
import ru.coffee.studentservicespring.domain.model.Classroom;
import ru.coffee.studentservicespring.domain.model.Student;
import ru.coffee.studentservicespring.domain.model.StudentProgress;
import ru.coffee.studentservicespring.repository.CommandWithStudentRepository;

import java.util.ArrayList;
import java.util.List;

public class CommandWithStudentRepositoryImpl implements CommandWithStudentRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public StudentDtoToChangeMark changeScore(StudentDtoToChangeMark student) {

        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Student> cq = cb.createQuery(Student.class);
        Root<Student> root = cq.from(Student.class);
        Predicate[] predicates = new Predicate[3];
        predicates[0] = cb.equal(root.get("name"), student.getName());
        predicates[1] = cb.equal(root.get("lastName"), student.getLastName());
        predicates[2] = cb.equal(root.get("classroom"), student.getClassroom());

        CriteriaQuery<Student> findId = cq.select(root).where(predicates);
        Query query = entityManager.createQuery(findId);

        List<Student> studentList = query.getResultList();

        CriteriaBuilder cbUpdate = entityManager.getCriteriaBuilder();
        CriteriaUpdate<StudentProgress> criteriaUpdate = cbUpdate.createCriteriaUpdate(StudentProgress.class);

        Root<StudentProgress> studentProgressRoot = criteriaUpdate.from(StudentProgress.class);
        criteriaUpdate.set(String.format(student.getLesson()), student.getScore());
        criteriaUpdate.where(cb.equal(studentProgressRoot.get("id"), studentList.get(0).getId()));

        entityManager.createQuery(criteriaUpdate).executeUpdate();
        return student;
    }
}
