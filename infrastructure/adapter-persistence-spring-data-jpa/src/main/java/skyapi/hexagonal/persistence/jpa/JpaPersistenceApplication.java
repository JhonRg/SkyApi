package skyapi.hexagonal.persistence.jpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JpaPersistenceApplication {
    public static void main(String[] args) {
        SpringApplication.run(JpaPersistenceApplication.class, args);
    }
}
