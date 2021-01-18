package lab4.jdbctemplate.config;

import lab4.jdbctemplate.repository.StudentRepositoryImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import lab4.jdbctemplate.repository.StudentRepository;
import lab4.jdbctemplate.service.StudentService;
import lab4.jdbctemplate.service.StudentServiceImpl;
import lab4.jdbctemplate.ui.ClientConsole;

@Configuration
public class AppConfig {
    @Bean
    ClientConsole clientConsole() {
        return new ClientConsole(studentService());
    }

    @Bean
    StudentService studentService() {
        return new StudentServiceImpl(studentRepository());
    }

    @Bean
    StudentRepository studentRepository() {
        return new StudentRepositoryImpl();
    }
}
