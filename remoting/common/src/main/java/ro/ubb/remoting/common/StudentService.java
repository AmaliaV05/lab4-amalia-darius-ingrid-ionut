package ro.ubb.remoting.common;

import java.util.List;

public interface StudentService {
    List<Student> getAllStudents();

    void save(Student student);

    void update(Student student);

    void delete(Long id);
}
