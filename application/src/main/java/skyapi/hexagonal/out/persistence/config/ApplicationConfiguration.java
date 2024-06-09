package skyapi.hexagonal.out.persistence.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import skyapi.hexagonal.in.service.MangaService;
import skyapi.hexagonal.in.api.MangaServiceController;
import skyapi.hexagonal.out.persistence.adapter.MangaPersistenceAdapter;
import skyapi.hexagonal.out.persistence.api.MangaRepositoryAdapter;

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
    @Bean
    public MangaServiceController mangaRestController (MangaService mangaService){
        return new MangaServiceController(mangaService);
    }
}
