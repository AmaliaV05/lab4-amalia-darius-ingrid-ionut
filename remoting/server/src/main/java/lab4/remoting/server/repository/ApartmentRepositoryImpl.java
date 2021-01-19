package lab4.remoting.server.repository;

import lab4.remoting.common.Apartment;
import lab4.remoting.common.ApartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;

import java.util.List;

public class ApartmentRepositoryImpl implements ApartmentRepository {

    @Autowired
    private JdbcOperations jdbcOperations;

    @Override
    public List<Apartment> findAll() {
        String sql = "select * from apartment";
        return jdbcOperations.query(sql, (rs, i) -> {
            Long id = rs.getLong("id");
            String address = rs.getString("address");
            String category = rs.getString("category");
            String description = rs.getString("description");
            String yearOfConstruction = rs.getString("yearOfConstruction");
            int price = rs.getInt("price");

            return new Apartment(id, address, category, description, yearOfConstruction, price);
        });
    }

    @Override
    public void save(Apartment apartment) {
        String sql = "insert into apartment (address,category,description,yearOfConstruction,price) values (?,?,?,?,?)";
        jdbcOperations.update(sql,apartment.getAddress(),apartment.getCategory(),
                apartment.getDescription(),apartment.getYearOfConstruction(),apartment.getPrice());
    }

    @Override
    public void update(Apartment apartment) {
        String sql = "update apartment set address = ?, category = ?, description = ?, yearOfConstruction = ?, price = ? where id = ?";
        jdbcOperations.update(sql,apartment.getAddress(),apartment.getCategory(),apartment.getDescription(),
                apartment.getYearOfConstruction(),apartment.getPrice(),apartment.getId());
    }

    @Override
    public void delete(Long id) {
        String sql = "delete from apartment where id=?";
        jdbcOperations.update(sql,id);
    }
}
