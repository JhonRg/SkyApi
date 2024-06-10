package skyapi.hexagonal.infrastructure.rest.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import skyapi.hexagonal.domain.ports.out.MangaPersistencePort;
import skyapi.hexagonal.domain.service.impl.MangaServiceImpl;

@Configuration
public class BootLoaderConfiguration {
//    @Bean
//    public MangaServiceImpl mangaServiceImpl (MangaPersistencePort mangaPersistencePort){
//        return new MangaServiceImpl(mangaPersistencePort);
//    }
}
