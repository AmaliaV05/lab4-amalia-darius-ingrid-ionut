package ro.ubb.remoting.server.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.rmi.RmiServiceExporter;
import ro.ubb.remoting.common.ApartmentService;
import ro.ubb.remoting.common.Student_ApartmentService;
import ro.ubb.remoting.server.repository.*;
import ro.ubb.remoting.common.StudentService;
import ro.ubb.remoting.server.service.ApartmentServiceImpl;
import ro.ubb.remoting.server.service.StudentApartmentServiceImpl;
import ro.ubb.remoting.server.service.StudentServiceImpl;

@Configuration
public class ServerConfig {
    @Bean
    RmiServiceExporter rmiServiceExporter() {  //the Exporter makes the service available to clients
        RmiServiceExporter rmiServiceExporter = new RmiServiceExporter();
        rmiServiceExporter.setServiceInterface(StudentService.class);//setServiceInterface() provides a reference to the
                                                                    //interface that will be made remotely callable
        rmiServiceExporter.setService(studentService());
        rmiServiceExporter.setServiceName("StudentService");//the client will be able to contact the StudentService
                                                            //at the following URL: rmi://host:1099/StudentService
        return rmiServiceExporter;
    }

    @Bean
    RmiServiceExporter rmiServiceExporter2() {
        RmiServiceExporter rmiServiceExporter = new RmiServiceExporter();
        rmiServiceExporter.setServiceInterface(ApartmentService.class);
        rmiServiceExporter.setService(apartmentService());
        rmiServiceExporter.setServiceName("ApartmentService");
        return rmiServiceExporter;
    }

    @Bean
    RmiServiceExporter rmiServiceExporter3() {
        RmiServiceExporter rmiServiceExporter = new RmiServiceExporter();
        rmiServiceExporter.setServiceInterface(Student_ApartmentService.class);
        rmiServiceExporter.setService(student_apartmentService());
        rmiServiceExporter.setServiceName("Student_ApartmentService");
        return rmiServiceExporter;
    }

    @Bean
    StudentService studentService() {
        return new StudentServiceImpl(studentRepository());
    }

    @Bean
    ApartmentService apartmentService() {
        return new ApartmentServiceImpl(apartmentRepository());
    }

    @Bean
    Student_ApartmentService student_apartmentService() {
        return new StudentApartmentServiceImpl(apartmentRepository(),studentRepository(),student_apartmentRepository());
    }

    @Bean
    StudentRepository studentRepository() {
        return new StudentRepositoryImpl();
    }

    @Bean
    ApartmentRepository apartmentRepository() {
        return new ApartmentRepositoryImpl();
    }

    @Bean
    Student_ApartmentRepository student_apartmentRepository() {
        return new Student_ApartmentRepositoryImpl();
    }
}
