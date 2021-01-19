package lab4.remoting.server.service;

import lab4.remoting.common.Apartment;
import lab4.remoting.common.ApartmentRepository;
import lab4.remoting.common.ApartmentService;

import java.util.List;

public class ApartmentServiceImpl implements ApartmentService {


    private ApartmentRepository apartmentRepository;

    public ApartmentServiceImpl(ApartmentRepository apartmentRepository) {
        this.apartmentRepository = apartmentRepository;
    }

    @Override
    public List<Apartment> getAllApartments() { return apartmentRepository.findAll();
    }

    @Override
    public void save(Apartment apartment) { apartmentRepository.save(apartment);

    }

    @Override
    public void update(Apartment apartment) { apartmentRepository.update(apartment);

    }

    @Override
    public void delete(Long id) { apartmentRepository.delete(id); }

    /*public List<Apartment> getAllApartments() {
        return Arrays.asList(
                new Apartment(1, "Horea","Semidecomandat", "","1999",1000),
                new Apartment(2, "Maniu", "Decomandat","", "2000", 1200)
        );
    }*/
}
