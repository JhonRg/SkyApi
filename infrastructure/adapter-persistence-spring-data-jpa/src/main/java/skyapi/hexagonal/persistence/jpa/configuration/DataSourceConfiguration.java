package skyapi.hexagonal.persistence.jpa.configuration;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import skyapi.hexagonal.persistence.jpa.repositories.MangaRepository;

import javax.sql.DataSource;

@Configuration
@ComponentScan(basePackageClasses = {MangaRepository.class})
public class DataSourceConfiguration {
    /**
     * Defining the data source programmatically by using the utility DataSourceBuilder()
     * This config could replace the spring.datasource configuration
     */
//    @Bean
//    public DataSource dataSource() {
//        return DataSourceBuilder.create()
//                .driverClassName("com.mysql.cj.jdbc.Driver")
//                .url("jdbc:mysql://localhost:3306/jpaDB")
//                .build();
//    }

//    @Bean
//    CommandLineRunner initDataSource(UserSpringJpaAdapater userSpringJpaAdapater) {
//        return args -> {
//            log.info("Preloading: " + userSpringJpaAdapater.createUser(
//                    User.builder()
//                            .id(UUID.randomUUID())
//                            .username("jonrg")
//                            .password("jonrg")
//                            .build()));
//        };
//    }
}
