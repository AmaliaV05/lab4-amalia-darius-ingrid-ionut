package lab4.remoting.client.service;

import lab4.remoting.common.*;
import org.springframework.beans.factory.annotation.Autowired;

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

    }

    @Override
    public void update(Apartment apartment) {

    }

    @Override
    public void delete(Apartment apartment) {

    }
}