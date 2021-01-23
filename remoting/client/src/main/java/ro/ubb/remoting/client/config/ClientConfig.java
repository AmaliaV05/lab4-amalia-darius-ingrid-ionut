package ro.ubb.remoting.client.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.rmi.RmiProxyFactoryBean;
import ro.ubb.remoting.client.service.ApartmentServiceClient;
import ro.ubb.remoting.client.service.StudentServiceClient;
import ro.ubb.remoting.client.service.Student_ApartmentServiceClient;
import ro.ubb.remoting.client.ui.ClientConsole;
import ro.ubb.remoting.common.ApartmentService;
import ro.ubb.remoting.common.StudentService;
import ro.ubb.remoting.common.Student_ApartmentService;

@Configuration
public class ClientConfig {
    @Bean
    RmiProxyFactoryBean rmiProxyFactoryBean1() {//request to the server side
        RmiProxyFactoryBean rmiProxyFactoryBean = new RmiProxyFactoryBean();
        rmiProxyFactoryBean.setServiceUrl("rmi://localhost:1099/StudentService");
        rmiProxyFactoryBean.setServiceInterface(StudentService.class);
        return rmiProxyFactoryBean;
    }

    @Bean
    RmiProxyFactoryBean rmiProxyFactoryBean2() {//request to the server side
        RmiProxyFactoryBean rmiProxyFactoryBean = new RmiProxyFactoryBean();
        rmiProxyFactoryBean.setServiceUrl("rmi://localhost:1099/ApartmentService");
        rmiProxyFactoryBean.setServiceInterface(ApartmentService.class);
        return rmiProxyFactoryBean;
    }

    @Bean
    ClientConsole clientConsole() { return new ClientConsole(studentServiceClient(), apartmentServiceClient(),student_apartmentServiceClient());
    }

    @Bean
    StudentService studentServiceClient() {
        return new StudentServiceClient();
    }

    @Bean
    ApartmentService apartmentServiceClient() {
        return new ApartmentServiceClient();
    }


    @Bean
    Student_ApartmentService student_apartmentServiceClient() {
        return new Student_ApartmentServiceClient();
    }
}
