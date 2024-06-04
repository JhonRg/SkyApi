package skyapi.hexagonal.persistence.jpa.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import skyapi.hexagonal.persistence.jpa.adapters.UserSpringJpaAdapater;
import skyapi.hexagonal.persistence.jpa.repositories.UserRepository;

@Configuration
public class SpringDataJpaAdapterConfiguration {

    @Bean
    public UserSpringJpaAdapater getUserPersistencePort(UserRepository userRepository) {
        return new UserSpringJpaAdapater(userRepository);
    }
}
