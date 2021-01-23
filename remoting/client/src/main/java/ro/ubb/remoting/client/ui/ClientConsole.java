package ro.ubb.remoting.client.ui;

import ro.ubb.remoting.common.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class ClientConsole {

    private StudentService studentService;
    private ApartmentService apartmentService;
    private Student_ApartmentService student_apartmentService;
    private Scanner scanner;

    public ClientConsole(StudentService studentService,ApartmentService apartmentService,Student_ApartmentService student_apartmentService) {

        this.studentService = studentService;
        this.apartmentService = apartmentService;
        this.student_apartmentService = student_apartmentService;
        this.scanner = new Scanner(System.in);
    }

    private void showMenu() {
        System.out.println("1. Student CRUD");
        System.out.println("2. Apartment CRUD");

        System.out.println("x. Exit");
    }

    public void runConsole() throws IOException {
        showMenu();
        while (true) {
            String option = scanner.next();
            switch (option) {
                case "1":
                    runStudentCRUD();
                    break;
                case "2":
                    runApartmentCRUD();
                    break;
                case "x":
                    return;
                default:
                    System.out.println("Invalid option!");
                    break;
            }
        }
    }


    private void runStudentCRUD() throws IOException {
        while (true) {
            System.out.println();
            System.out.println("1. Add a client");
            System.out.println("2. View all clients");
            System.out.println("3. Delete a client by a given id");
            System.out.println("4. Update a client");
            System.out.println("5. Add apartment for student");
            System.out.println("6. Show apartments");
            System.out.println("7. Back");

            BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
            String option = bufferRead.readLine();
            switch (option) {
                case "1":
                    addStudent();
                    break;
                case "2":
                    printAllStudents();
                    break;
                case "3":
                    deleteStudentById();
                    break;
                case "4":
                    updateStudent();
                    break;
                case "5":
                    addApartmenttoStudent();
                    break;
                case "6":
                    showApartmenttoStudent();
                    break;
                case "7":
                    showMenu();
                    return;
                default:
                    System.out.println("Invalid option!");
                    break;
            }
        }
    }


    private void addApartmenttoStudent() throws IOException {
        BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
        try {

            System.out.println("Enter student id: ");
            Long id_student = Long.parseLong(bufferRead.readLine());
            System.out.println("Enter apartment id: ");
            Long id_apartment = Long.parseLong(bufferRead.readLine());

            Student_Apartment s1 = new Student_Apartment(null, id_student , id_apartment );
            student_apartmentService.save(s1);

        } catch (NumberFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void addStudent() throws IOException {
        BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.println("Enter id: ");
            Long id = Long.parseLong(bufferRead.readLine());
            System.out.println("Enter name: ");
            String name = bufferRead.readLine();
            System.out.println("Enter grade: ");
            int grade = Integer.parseInt(bufferRead.readLine());

        Student s1 = new Student(id, name, grade);
        studentService.save(s1);
        } catch (NumberFormatException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
    }

    private void printAllStudents() {
        studentService.getAllStudents()
                .forEach(student -> System.out.println(student));
    }


    private  void  showApartmenttoStudent() throws IOException {
        BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter student id: ");
        Long id_student = Long.parseLong(bufferRead.readLine());

        student_apartmentService.getAllStudent_Apartment(id_student)
                .forEach(student -> System.out.println(student));

    }

    private void deleteStudentById() {
        BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.println("Enter id: ");
            Long id = Long.parseLong(bufferRead.readLine());

            studentService.delete(id);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("The client was deleted!");
    }

    private void updateStudent() {
        BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));

        try {
            System.out.println("Enter id: ");
            Long id = Long.parseLong(bufferRead.readLine());
            System.out.println("Enter name: ");
            String name = bufferRead.readLine();
            System.out.println("Enter grade: ");
            int grade = Integer.parseInt(bufferRead.readLine());

            Student s1 = new Student(id, name, grade);
            studentService.update(s1);

        } catch (IOException ex) {
            ex.printStackTrace();

        }
        System.out.println("The client was updated!");
    }
    private void runApartmentCRUD() throws IOException {
        while (true) {
            System.out.println();
            System.out.println("1. Add a Apartment");
            System.out.println("2. View all Apartments");
            System.out.println("3. Delete a Apartment by a given id");
            System.out.println("4. Update a Apartment");
            System.out.println("5. Filter by category");
            System.out.println("6. Back");

            BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
            String option = bufferRead.readLine();
            switch (option) {
                case "1":
                    addApartment();
                    break;
                case "2":
                    printAllApartments();
                    break;
                case "3":
                    deleteApartmentById();
                    break;
                case "4":
                    updateApartment();
                    break;
                case "5":
                    filterByCategory();
                    break;
                case "6":
                    showMenu();
                    return;
                default:
                    System.out.println("Invalid option!");
                    break;
            }
        }
    }


    private void addApartment() throws IOException{
        BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Enter Address: ");
        String address = bufferRead.readLine();
        System.out.println("Enter Category: ");
        String category = bufferRead.readLine();
        System.out.println("Enter Description: ");
        String description = bufferRead.readLine();
        System.out.println("Enter price: ");
        double price = Double.parseDouble(bufferRead.readLine());
        System.out.println("Enter year of construction: ");
        String yearOfconstruction = bufferRead.readLine();

        Apartment ap = new Apartment(null,address, category, description, yearOfconstruction, price);


        apartmentService.save(ap);
    }

    private void printAllApartments() {
        apartmentService.getAllApartments()
                .forEach(apartment -> System.out.println(apartment));
    }

    private void filterByCategory() throws IOException {

        BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Enter category: ");
        String category = bufferRead.readLine();
        apartmentService.getAllApartmentsByCategory(category)
                .forEach(apartment -> System.out.println(apartment));
    }

    private void deleteApartmentById() {
        BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.println("Enter id: ");
            Long id = Long.parseLong(bufferRead.readLine());

            apartmentService.delete(id);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void updateApartment() {
        BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));

        try {
            System.out.println("Enter id: ");
            Long id = Long.parseLong(bufferRead.readLine());
            System.out.println("Enter Address: ");
            String address = bufferRead.readLine();
            System.out.println("Enter Category: ");
            String category = bufferRead.readLine();
            System.out.println("Enter Description: ");
            String description = bufferRead.readLine();
            System.out.println("Enter price: ");
            double price = Double.parseDouble(bufferRead.readLine());
            System.out.println("Enter year of construction: ");
            String yearOfConstruction = bufferRead.readLine();

            Apartment ap = new Apartment(id, address, category, description, yearOfConstruction, price);
            ap.setId(id);

            apartmentService.update(ap);

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
