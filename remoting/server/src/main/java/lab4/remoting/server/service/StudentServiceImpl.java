package lab4.remoting.server.service;

import lab4.remoting.common.Student;
import lab4.remoting.common.StudentService;

import java.util.Arrays;
import java.util.List;

public class StudentServiceImpl implements StudentService {
    public List<Student> getAllStudents() {
        return Arrays.asList(
                new Student(1l, "s1", 10),
                new Student(2L, "s2", 10)
        );
    }
}
