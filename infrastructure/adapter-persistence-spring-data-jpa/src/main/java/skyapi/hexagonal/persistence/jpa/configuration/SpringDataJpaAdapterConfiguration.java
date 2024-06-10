package skyapi.hexagonal.persistence.jpa.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import skyapi.hexagonal.domain.ports.out.MangaPersistencePort;
import skyapi.hexagonal.domain.service.impl.MangaServiceImpl;
import skyapi.hexagonal.persistence.jpa.adapters.MangaSpringJpaAdapter;
import skyapi.hexagonal.persistence.jpa.repositories.MangaRepository;

@Configuration
@ComponentScan(basePackageClasses = {MangaRepository.class})
public class SpringDataJpaAdapterConfiguration {

    @Bean
    public MangaSpringJpaAdapter mangaSpringJpaAdapter(MangaRepository mangaRepository) {
        return new MangaSpringJpaAdapter(mangaRepository);
    }
    @Bean
    public MangaServiceImpl mangaServiceImpl (MangaPersistencePort mangaPersistencePort){
        return new MangaServiceImpl(mangaPersistencePort);
    }
}
