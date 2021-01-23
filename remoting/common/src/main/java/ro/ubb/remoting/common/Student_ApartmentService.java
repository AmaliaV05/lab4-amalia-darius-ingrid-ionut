package ro.ubb.remoting.common;

import java.util.List;

public interface Student_ApartmentService {
    List<Apartment> getAllStudent_Apartment(Long id_student);

    void save(Student_Apartment studap);
}
