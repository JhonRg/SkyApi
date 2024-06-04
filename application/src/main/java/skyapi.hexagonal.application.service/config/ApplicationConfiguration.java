package skyapi.hexagonal.application.service.config;

import com.Sky.SkyApi.application.adapter.UserServiceAdapter;
import com.Sky.SkyApi.domain.ports.UserPersistencePort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfiguration {

    @Bean
    public UserServiceAdapter getUserServiceAdapter(UserPersistencePort userPersistencePort) {
        return new UserServiceAdapter(userPersistencePort);
    }
}
