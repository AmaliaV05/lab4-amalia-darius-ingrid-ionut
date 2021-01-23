package ro.ubb.remoting.server;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ServerApp {
    public static void main(String[] args) {
        System.out.println("server started");

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext("ro.ubb.remoting.server.config");
    }
}


/*
Lab4 · work in teams; accept the assignment: https://classroom.github.com/g/UKHxS4nr

        · convert your project (Lab3) from a client-server application using sockets to an application using RMI

        · use Spring remoting

        · data must be persisted to a database; use JdbcTemplate (Spring)

        · use Gradle for dependency management

        · xml configuration for Spring is not allowed; annotations and Java Config classes only

        · all features needed (including filters and reports)*/
