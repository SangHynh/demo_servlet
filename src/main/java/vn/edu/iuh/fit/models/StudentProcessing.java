package vn.edu.iuh.fit.models;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import vn.edu.iuh.fit.dtos.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentProcessing {
    @PersistenceContext(unitName = "demo")
    private EntityManager entityManager;

    @Transactional
    public void addStudent(String fullname, String email) {
        try {
            Student student = new Student();
            student.setFullname(fullname);
            student.setEmail(email);
            entityManager.persist(student);
        } catch (Exception e) {
            // Xử lý ngoại lệ (ghi log hoặc ném ra một ngoại lệ khác)
            throw new RuntimeException("Error while adding student: " + e.getMessage(), e);
        }
    }


    public List<Student> listStudents() {
        TypedQuery<Student> q = entityManager.createQuery("select s from Student s", Student.class);
        return q.getResultList();
    }
    public Student listStudents(long id) {
        TypedQuery<Student> q = entityManager.createQuery("select s from Student s where s.id=:id", Student.class);
        q.setParameter("id", id);
        return q.getSingleResult();
    }
}
