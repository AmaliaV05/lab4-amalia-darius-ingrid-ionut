package lab4.jdbctemplate.ui;

import lab4.jdbctemplate.model.Student;
import lab4.jdbctemplate.service.StudentService;

public class ClientConsole {
    private StudentService studentService;

    public ClientConsole(StudentService studentService) {
        this.studentService = studentService;
    }

    public void runConsole() {
        studentService.save(new Student(null,"Popescu",5));



        studentService.getAllStudents()
                .forEach(student -> System.out.println(student));

        Student student = studentService.getAllStudents().get(0);
        student.setGrade(7);
        studentService.update(student);
        System.out.println("\nAfter Update");

        studentService.getAllStudents()
                .forEach(student2 -> System.out.println(student2));

        studentService.delete(student.getId());

        System.out.println("\nAfter delete");

        studentService.getAllStudents()
                .forEach(student2 -> System.out.println(student2));


    }
}
