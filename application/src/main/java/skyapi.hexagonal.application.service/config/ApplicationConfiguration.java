package skyapi.hexagonal.application.service.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import skyapi.hexagonal.application.service.adapter.UserServiceAdapter;
import skyapi.hexagonal.domain.ports.UserPersistencePort;

@Configuration
public class ApplicationConfiguration {

    @Bean
    public UserServiceAdapter getUserServiceAdapter(UserPersistencePort userPersistencePort) {
        return new UserServiceAdapter(userPersistencePort);
    }
}
