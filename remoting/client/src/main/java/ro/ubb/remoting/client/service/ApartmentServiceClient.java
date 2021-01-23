package ro.ubb.remoting.client.service;

import org.springframework.beans.factory.annotation.Autowired;
import ro.ubb.remoting.common.Apartment;
import ro.ubb.remoting.common.ApartmentService;

import java.util.List;

public class ApartmentServiceClient implements ApartmentService {

    @Autowired
    private ApartmentService apartmentService;

    @Override
    public List<Apartment> getAllApartments() {
        return apartmentService.getAllApartments();
    }

    @Override
    public void save(Apartment apartment) {
        apartmentService.save(apartment);
    }

    @Override
    public void update(Apartment apartment) {
        apartmentService.update(apartment);
    }

    @Override
    public void delete(Long id) {
        apartmentService.delete(id);
    }

    @Override
    public List<Apartment> getAllApartmentsByCategory(String category) {
       return apartmentService.getAllApartmentsByCategory(category);
    }
}
