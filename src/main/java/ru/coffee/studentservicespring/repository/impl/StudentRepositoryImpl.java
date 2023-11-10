package ru.coffee.studentservicespring.repository.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.stereotype.Repository;
import ru.coffee.studentservicespring.domain.dto.StudentDtoForAdding;
import ru.coffee.studentservicespring.domain.dto.StudentDtoWithAverageScore;
import ru.coffee.studentservicespring.domain.dto.StudentDtoToChangeScore;
import ru.coffee.studentservicespring.repository.StudentRepository;

import java.util.List;

@Repository
public class StudentRepositoryImpl implements StudentRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void addStudent(StudentDtoForAdding student) {
//
//        String sqlDefaultRow = "INSERT INTO student_progress (physic) VALUES (0)";
//
//        String sql = "INSERT INTO student (name, last_name, age, class_id, sp_id) " +
//                     "VALUES (:name, :lastName, :age, :classroom)";
//        entityManager.createQuery(sqlDefaultRow).executeUpdate();
//        Query query = entityManager.createQuery(sql);
//        query.setParameter("name", student.getName()).setParameter("lastName", student.getLastName())
//                .setParameter("age", student.getAge()).setParameter("classroom", student.getClassroom())
//                .executeUpdate();

    }

    @Override
    public List<StudentDtoWithAverageScore> getAverageScore(int classroom) {
//        String sql = "SELECT p.name, p.last_name, p.class_id, (pp.rus + pp.literature + pp.mathematics " +
//                     "pp.geometry + pp.informatics + pp.physic) / 6 AS average " +
//                     "FROM person p " +
//                     "JOIN class c on p.class_id = c.class_id " +
//                     "JOIN person_progress pp on p.pp_id = pp.pp_id " +
//                     "WHERE p.class_id = :classroom";
//        return (List<StudentDtoWithAverageScore>) entityManager.createQuery(sql)
//                .setParameter("classroom", classroom)
//                .getResultList();
        return null;
    }

    @Override
    public void changeScore(StudentDtoToChangeScore student) {
//        String sql = String.format("UPDATE person_progress \n" +
//                                   "SET %s = :score " +
//                                   "WHERE pp_id = (" +
//                                   "SELECT p.pp_id " +
//                                   "FROM person p " +
//                                   "JOIN class c " +
//                                   "ON p.class_id = c.class_id " +
//                                   "WHERE p.name = :name " +
//                                   "AND p.last_name = :lastName " +
//                                   "AND p.class_id = :classroom)", student.getLesson());
//        Query query = entityManager.createQuery(sql);
//        query.setParameter("score", student.getScore())
//                .setParameter("name", student.getName())
//                .setParameter("lastName", student.getLastName())
//                .setParameter("classroom", student.getClassroom())
//                .executeUpdate();
    }
}
