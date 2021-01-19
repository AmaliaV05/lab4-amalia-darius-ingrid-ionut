package lab4.remoting.server.config;

import lab4.remoting.common.ApartmentService;
import lab4.remoting.server.service.ApartmentServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.rmi.RmiServiceExporter;

@Configuration
public class ServerConfig {
    @Bean
    RmiServiceExporter rmiServiceExporter() {
        RmiServiceExporter rmiServiceExporter = new RmiServiceExporter();
        rmiServiceExporter.setServiceInterface(ApartmentService.class);
        rmiServiceExporter.setService(new ApartmentServiceImpl());
        rmiServiceExporter.setServiceName("ApartmentService");
        return rmiServiceExporter;
    }
}
