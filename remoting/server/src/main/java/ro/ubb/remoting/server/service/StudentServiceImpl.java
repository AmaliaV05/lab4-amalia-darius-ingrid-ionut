package ro.ubb.remoting.server.service;

import ro.ubb.remoting.common.Student;
import ro.ubb.remoting.common.StudentService;
import ro.ubb.remoting.server.repository.StudentRepository;

import java.util.List;

public class StudentServiceImpl implements StudentService {

/*    public List<Student> getAllStudents() {
        return Arrays.asList(
                new Student(1l, "s1", 10),
                new Student(2L, "s2", 10)
        );
    }*/

    private StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public void save(Student student) {
        studentRepository.save(student);
    }

    @Override
    public void update(Student student) {
        studentRepository.update(student);
    }

    @Override
    public void delete(Long id) {
        studentRepository.delete(id);
    }



}
