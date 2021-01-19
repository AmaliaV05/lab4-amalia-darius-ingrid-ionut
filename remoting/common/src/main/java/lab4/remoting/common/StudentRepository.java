package lab4.remoting.common;

import java.util.List;

public interface StudentRepository {
    List<Student> findAll();
    void save(Student student);
    void  update(Student student);
    void delete(Long id);
}
