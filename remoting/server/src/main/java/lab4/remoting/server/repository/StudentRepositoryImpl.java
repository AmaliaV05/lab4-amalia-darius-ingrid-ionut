package lab4.remoting.server.repository;

import lab4.remoting.common.Student;
import lab4.remoting.common.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;

import java.util.List;


public class StudentRepositoryImpl implements StudentRepository {
    @Autowired
    private JdbcOperations jdbcOperations;

    @Override
    public List<Student> findAll() {
        String sql = "select * from student";
        return jdbcOperations.query(sql, (rs, i) -> {
            Long id = rs.getLong("id");
            String name = rs.getString("name");
            int grade = rs.getInt("grade");

            return new Student(id, name, grade);
        });
    }

    @Override
    public void save(Student student) {
        String sql = "insert into student (name,grade) values (?,?)";
        jdbcOperations.update(sql,student.getName(),student.getGrade());
    }

    @Override
    public void update(Student student) {
        String sql = "update student set name = ?, grade = ? where id = ?";
        jdbcOperations.update(sql,student.getName(),student.getGrade(),student.getId());
    }

    @Override
    public void delete(Long id) {
        String sql = "delete from student where id=?";
        jdbcOperations.update(sql,id);
    }
}
