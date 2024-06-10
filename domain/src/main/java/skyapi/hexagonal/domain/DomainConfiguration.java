package skyapi.hexagonal.domain;

import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import skyapi.hexagonal.domain.ports.out.MangaPersistencePort;

@Configuration
@ComponentScan(basePackageClasses = {MangaPersistencePort.class})
public class DomainConfiguration {

}
