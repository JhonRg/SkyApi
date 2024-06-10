package skyapi.hexagonal.infrastructure.rest.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import skyapi.hexagonal.application.in.api.impl.MangaServiceControllerImpl;
import skyapi.hexagonal.domain.service.MangaService;
import skyapi.hexagonal.domain.ports.out.MangaPersistencePort;
import skyapi.hexagonal.domain.service.impl.MangaServiceImpl;

@Configuration
public class ApplicationConfiguration {

    @Bean
    public MangaServiceImpl mangaServiceImpl (MangaPersistencePort mangaPersistencePort){
        return new MangaServiceImpl(mangaPersistencePort);
    }
    @Bean
    public MangaServiceControllerImpl mangaServiceControllerImpl (MangaService mangaService){
        return new MangaServiceControllerImpl(mangaService);
    }
}
