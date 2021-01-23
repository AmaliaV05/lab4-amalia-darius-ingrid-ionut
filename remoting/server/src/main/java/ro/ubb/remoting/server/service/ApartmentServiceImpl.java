package ro.ubb.remoting.server.service;

import ro.ubb.remoting.common.Apartment;
import ro.ubb.remoting.common.ApartmentService;
import ro.ubb.remoting.common.Student;
import ro.ubb.remoting.server.repository.ApartmentRepository;
import ro.ubb.remoting.server.repository.StudentRepository;

import java.util.List;
import java.util.stream.Collectors;

public class ApartmentServiceImpl implements ApartmentService {

    private ApartmentRepository apartmentRepository;

    public ApartmentServiceImpl(ApartmentRepository apartmentRepository) {
        this.apartmentRepository = apartmentRepository;
    }

    @Override
    public List<Apartment> getAllApartments() {
        return apartmentRepository.findAll();
    }

    @Override
    public void save(Apartment apartment) {
        apartmentRepository.save(apartment);
    }

    @Override
    public void update(Apartment apartment) {
        apartmentRepository.update(apartment);
    }

    @Override
    public void delete(Long id) {
        apartmentRepository.delete(id);
    }

    @Override
    public List<Apartment> getAllApartmentsByCategory(String category) {
       List<Apartment> la = apartmentRepository.findAll();

        List<Apartment>  fs = la.stream()
                .filter(ap -> ap.getCategory().contains(category))
                .collect(Collectors.toList());

       return fs;
        // return apartmentRepository.findAllByCategory(category);
    }
}
