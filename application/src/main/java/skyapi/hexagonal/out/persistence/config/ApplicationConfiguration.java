package skyapi.hexagonal.out.persistence.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import skyapi.hexagonal.in.api.impl.MangaServiceControllerImpl;
import skyapi.hexagonal.in.service.impl.MangaServiceImpl;
import skyapi.hexagonal.out.persistence.adapter.MangaPersistenceAdapter;
import skyapi.hexagonal.out.persistence.api.MangaRepositoryAdapter;

@Configuration
public class ApplicationConfiguration {

    @Bean
    public MangaPersistenceAdapter mangaPersistenceAdapter(MangaRepositoryAdapter mangaRepositoryAdapter) {
        return new MangaPersistenceAdapter(mangaRepositoryAdapter);
    }
    @Bean
    public MangaServiceControllerImpl mangaRestController (MangaServiceImpl mangaService){
        return new MangaServiceControllerImpl(mangaService);
    }
}
