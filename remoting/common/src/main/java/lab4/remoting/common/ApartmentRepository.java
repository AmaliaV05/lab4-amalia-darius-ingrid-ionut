package lab4.remoting.common;

import java.util.List;

public interface ApartmentRepository {

    List<Apartment> findAll();
    void save(Apartment apartment);
    void  update(Apartment apartment);
    void delete(Long id);
}
