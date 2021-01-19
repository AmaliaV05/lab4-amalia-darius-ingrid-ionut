package lab4.remoting.client.service;

import org.springframework.beans.factory.annotation.Autowired;
import lab4.remoting.common.Student;
import lab4.remoting.common.StudentService;

import java.util.List;

public class StudentServiceClient implements StudentService {

    @Autowired
    private StudentService studentService;


    @Override
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @Override
    public void save(Student student) {

    }

    @Override
    public void update(Student student) {

    }

    @Override
    public void delete(Long id) {

    }
}
