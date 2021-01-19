package lab4.remoting.client.ui;

import lab4.remoting.common.ApartmentService;

public class ClientConsole {
    private ApartmentService apartmentService;

    public ClientConsole(ApartmentService apartmentService) {
        this.apartmentService = apartmentService;
    }

    public void runConsole() {
        apartmentService.getAllApartments()
                .forEach(apartment -> System.out.println(apartment));

        /*        studentService.save(new Student(null,"Popescu",5));

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
                .forEach(student2 -> System.out.println(student2));*/

    }
}
