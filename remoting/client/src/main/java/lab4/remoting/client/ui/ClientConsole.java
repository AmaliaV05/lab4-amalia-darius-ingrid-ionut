package lab4.remoting.client.ui;

import lab4.remoting.common.StudentService;

public class ClientConsole {
    private StudentService studentService;

    public ClientConsole(StudentService studentService) {
        this.studentService = studentService;
    }

    public void runConsole() {
        studentService.getAllStudents()
                .forEach(student -> System.out.println(student));
    }
}
