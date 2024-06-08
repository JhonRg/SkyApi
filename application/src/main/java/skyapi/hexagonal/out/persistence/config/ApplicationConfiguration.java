package skyapi.hexagonal.out.persistence.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import skyapi.hexagonal.out.persistence.adapter.MangaPersistenceAdapter;
import skyapi.hexagonal.out.persistence.adapter.UserServiceAdapter;
import skyapi.hexagonal.out.persistence.api.MangaRepositoryAdapter;
import skyapi.hexagonal.out.persistence.api.UserService;

@Configuration
public class ApplicationConfiguration {

    @Bean
    public UserServiceAdapter getUserServiceAdapter(UserService userSpringJpaAdapater) {
        return new UserServiceAdapter(userSpringJpaAdapater);
    }
    @Bean
    public MangaPersistenceAdapter mangaPersistenceAdapter(MangaRepositoryAdapter mangaRepositoryAdapter) {
        return new MangaPersistenceAdapter(mangaRepositoryAdapter);
    }
}
