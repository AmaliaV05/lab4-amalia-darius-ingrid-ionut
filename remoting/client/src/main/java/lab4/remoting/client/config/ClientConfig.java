package lab4.remoting.client.config;

import lab4.remoting.client.service.*;
import lab4.remoting.common.*;
import lab4.remoting.server.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.rmi.RmiProxyFactoryBean;
import lab4.remoting.client.ui.ClientConsole;

@Configuration
public class ClientConfig {
    @Bean
    RmiProxyFactoryBean rmiProxyFactoryBean() {
        RmiProxyFactoryBean rmiProxyFactoryBean = new RmiProxyFactoryBean();
        rmiProxyFactoryBean.setServiceUrl("rmi://localhost:1099/ApartmentService");
        rmiProxyFactoryBean.setServiceInterface(ApartmentService.class);
        return rmiProxyFactoryBean;
    }

    @Bean
    ClientConsole clientConsole() {
        return new ClientConsole(apartmentServiceClient());
    }

    @Bean
    ApartmentService apartmentServiceClient() { return new ApartmentServiceClient(); }

    @Bean
    ApartmentRepository apartmentRepository() { return new ApartmentRepositoryImpl(); }

}
