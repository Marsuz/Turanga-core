package app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by Marcin on 2016-08-20.
 */

@SpringBootApplication
@ComponentScan("core")
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}
