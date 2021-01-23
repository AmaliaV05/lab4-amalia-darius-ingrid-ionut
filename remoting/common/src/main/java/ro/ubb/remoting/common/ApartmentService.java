package ro.ubb.remoting.common;

import java.util.List;

public interface ApartmentService {
    List<Apartment> getAllApartments();

    void save(Apartment apartment);

    void update(Apartment apartment);

    void delete(Long id);

    List<Apartment> getAllApartmentsByCategory(String category);
}
