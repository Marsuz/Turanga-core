package app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Created by Marcin on 2016-08-20.
 */

@SpringBootApplication
@EntityScan(basePackages = { "common", "stubs", "tasks", "wrappers" })
@ComponentScan(basePackages = {"app", "repositories", "utils", "stubs", "tasks", "wrappers", "controllers", "services", "queries"})
@EnableJpaRepositories(basePackages = {"repositories"})
public class App {

    @Bean
    static PropertySourcesPlaceholderConfigurer propertyPlaceHolderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(App.class, args);
    }

}
