package ro.ubb.remoting.client.service;

import org.springframework.beans.factory.annotation.Autowired;
import ro.ubb.remoting.common.Student;
import ro.ubb.remoting.common.StudentService;

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
        studentService.save(student);
    }

    @Override
    public void update(Student student) {
        studentService.update(student);
    }

    @Override
    public void delete(Long id) {
        studentService.delete(id);
    }
}
