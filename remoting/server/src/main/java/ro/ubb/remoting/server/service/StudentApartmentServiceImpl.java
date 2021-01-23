package ro.ubb.remoting.server.service;

import ro.ubb.remoting.common.*;
import ro.ubb.remoting.server.repository.ApartmentRepository;
import ro.ubb.remoting.server.repository.StudentRepository;
import ro.ubb.remoting.server.repository.Student_ApartmentRepository;

import java.util.List;
import java.util.stream.Collectors;

public class StudentApartmentServiceImpl implements Student_ApartmentService {
    private ApartmentRepository apartmentRepository;
    private StudentRepository studentRepository;
    private Student_ApartmentRepository student_apartmentRepository;

    public StudentApartmentServiceImpl(ApartmentRepository apartmentRepository, StudentRepository studentRepository, Student_ApartmentRepository student_apartmentRepository) {
        this.apartmentRepository = apartmentRepository;
        this.studentRepository = studentRepository;
        this.student_apartmentRepository = student_apartmentRepository;
    }

    @Override
    public List<Apartment> getAllStudent_Apartment( Long id_student) {
        List<Student_Apartment> lsa = student_apartmentRepository.findAll();
        // id id_student id_apartament
        // 1    1              1
        // 2    1              2

        List<Student> ls = studentRepository.findAll();
        // 1 , 2 ,3 ,4 ,5
       // List<Student> ls_filter = ls.stream()
      //         .filter(student -> student.getId().equals( id_student ) )
      //          .collect(Collectors.toList());

        List<Apartment> la_filter = apartmentRepository.findAll()
                .stream()
                .filter(apartment -> lsa.contains(apartment.getId()))  //apartment.getId().equals( 1L ) )
                .collect(Collectors.toList());


        return la_filter;

    }

    @Override
    public void save(Student_Apartment studap) {
        student_apartmentRepository.save(studap);
    }
}
