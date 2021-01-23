package ro.ubb.remoting.server.repository;

import ro.ubb.remoting.common.Apartment;
import ro.ubb.remoting.common.Student;
import ro.ubb.remoting.common.Student_Apartment;

import java.util.List;

public interface Student_ApartmentRepository {
    List<Student_Apartment> findAll();
    void save(Student_Apartment apstud);
}
