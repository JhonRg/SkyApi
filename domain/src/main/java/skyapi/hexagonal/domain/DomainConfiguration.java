package skyapi.hexagonal.domain;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import skyapi.hexagonal.domain.ports.out.MangaPersistencePort;
import skyapi.hexagonal.domain.service.impl.MangaServiceImpl;

@Configuration
@ComponentScan(basePackageClasses = {MangaPersistencePort.class})
public class DomainConfiguration {

}
