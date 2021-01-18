package lab4.jdbctemplate.service;

import lab4.jdbctemplate.model.Student;

import java.util.List;

public interface StudentService {
    List<Student> getAllStudents();

    void save(Student student);

    void update(Student student);

    void delete(Long id);
}
