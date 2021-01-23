package ro.ubb.remoting.server.repository;


import ro.ubb.remoting.common.Apartment;
import ro.ubb.remoting.common.Student;
import java.util.List;


public interface ApartmentRepository {

    List<Apartment> findAll();
    void save(Apartment apartment);
    void  update(Apartment apartment);
    void delete(Long id);
//    List<Apartment> findAllByCategory(String category);
}
