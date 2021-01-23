package ro.ubb.remoting.server.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import ro.ubb.remoting.common.Apartment;


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
        //id from database, autoincrement!!!!!
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

/*    @Override
    public List<Apartment> findAllByCategory(String categ) {//se considera calcule complexe, facute la nivel de service!!!
        // fara sql
        // fara id de la tastatura
        //legatura intre tabele
        String sql = "select * from apartment where category = ?";

        return jdbcOperations.query(sql, (rs, i) -> {
            Long id = rs.getLong("id");
            String address = rs.getString("address");
            String category = rs.getString("category");
            String description = rs.getString("description");
            String yearOfConstruction = rs.getString("yearOfConstruction");
            int price = rs.getInt("price");

            return new Apartment(id, address, category, description, yearOfConstruction, price);
        }
        ,categ);

    }*/

/*    @Override
    public String getPortalUserName(final int uPortalUID) {
        final List<String> results =
                this.jdbcOperations.queryForList(
                        "SELECT USER_NAME FROM UP_USER WHERE USER_ID=?", String.class, uPortalUID);
        return DataAccessUtils.singleResult(results);
    }*/

}
