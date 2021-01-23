package ro.ubb.remoting.server.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import ro.ubb.remoting.common.Student_Apartment;

import java.util.List;

public class Student_ApartmentRepositoryImpl implements Student_ApartmentRepository {

    @Autowired
    private JdbcOperations jdbcOperations;

    @Override
    public List<Student_Apartment> findAll() {
        String sql = "select * from Student_Apartment";  // 1 1-id student  2-id apartment
        return jdbcOperations.query(sql, (rs, i) -> {
            Long id = rs.getLong("id");
           Long id_student = rs.getLong("idstudent");
           Long id_apartment = rs.getLong("idapartment");

            return new Student_Apartment(id, id_student, id_apartment);
        });
    }

    @Override
    public void save(Student_Apartment apstud) {
        String sql = "insert into Student_Apartment (idstudent,idapartment) values (?,?)";
        //id from database, autoincrement!!!!!
        jdbcOperations.update(sql,apstud.getIdStudent(), apstud.getIdApartment());
    }


}
