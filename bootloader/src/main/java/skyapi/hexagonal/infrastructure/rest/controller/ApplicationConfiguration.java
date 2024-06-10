package skyapi.hexagonal.infrastructure.rest.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import skyapi.hexagonal.application.in.api.impl.MangaServiceControllerImpl;
import skyapi.hexagonal.domain.service.MangaService;
import skyapi.hexagonal.domain.ports.out.MangaPersistencePort;
import skyapi.hexagonal.domain.service.impl.MangaServiceImpl;
import skyapi.hexagonal.out.persistence.adapter.MangaPersistenceJpaAdapter;

@Configuration
public class ApplicationConfiguration {

    @Bean
    public MangaPersistenceJpaAdapter mangaPersistenceAdapter(MangaPersistencePort mangaPersistencePort) {
        return new MangaPersistenceJpaAdapter(mangaPersistencePort);
    }
    @Bean
    public MangaServiceImpl mangaServiceImpl (MangaPersistencePort mangaPersistencePort){
        return new MangaServiceImpl(mangaPersistencePort);
    }
    @Bean
    public MangaServiceControllerImpl mangaServiceControllerImpl (MangaService mangaService){
        return new MangaServiceControllerImpl(mangaService);
    }
}
