package lab4.remoting.server.config;

import lab4.remoting.server.service.StudentServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.rmi.RmiServiceExporter;
import lab4.remoting.common.StudentService;

@Configuration
public class ServerConfig {
    @Bean
    RmiServiceExporter rmiServiceExporter() {
        RmiServiceExporter rmiServiceExporter = new RmiServiceExporter();
        rmiServiceExporter.setServiceInterface(StudentService.class);
        rmiServiceExporter.setService(new StudentServiceImpl());
        rmiServiceExporter.setServiceName("StudentService");
        return rmiServiceExporter;
    }
}
