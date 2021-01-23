package ro.ubb.remoting.server.repository;

import ro.ubb.remoting.common.Student;

import java.util.List;

public interface StudentRepository {
    List<Student> findAll();
    void save(Student student);
    void  update(Student student);
    void delete(Long id);
}
