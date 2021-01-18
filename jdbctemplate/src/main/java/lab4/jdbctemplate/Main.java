package lab4.jdbctemplate;

import lab4.jdbctemplate.ui.ClientConsole;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(
                        "lab4.jdbctemplate.config"
                );

        ClientConsole clientConsole = context.getBean(ClientConsole.class);
        clientConsole.runConsole();

        System.out.println("bye");
    }
}
