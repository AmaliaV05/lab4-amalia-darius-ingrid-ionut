package ro.ubb.remoting.client.service;

import org.springframework.beans.factory.annotation.Autowired;
import ro.ubb.remoting.common.Apartment;
import ro.ubb.remoting.common.ApartmentService;
import ro.ubb.remoting.common.Student_Apartment;
import ro.ubb.remoting.common.Student_ApartmentService;

import java.util.List;

public class Student_ApartmentServiceClient implements Student_ApartmentService {

    @Autowired
    private Student_ApartmentService student_apartmentService;


    @Override
    public List<Apartment> getAllStudent_Apartment(Long id_student) {
        return student_apartmentService.getAllStudent_Apartment(id_student);
    }

    @Override
    public void save(Student_Apartment studap) {
        student_apartmentService.save(studap);
    }

}
