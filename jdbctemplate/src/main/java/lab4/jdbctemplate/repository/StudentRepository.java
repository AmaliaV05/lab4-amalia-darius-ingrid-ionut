package lab4.jdbctemplate.repository;

import lab4.jdbctemplate.model.Student;

import java.util.List;

public interface StudentRepository {
    List<Student> findAll();
    void save(Student student);
    void  update(Student student);
    void delete(Long id);
}
