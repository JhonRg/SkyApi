package skyapi.hexagonal.persistence.jpa.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import skyapi.hexagonal.persistence.jpa.adapters.MangaSpringJpaAdapter;
import skyapi.hexagonal.persistence.jpa.repositories.MangaRepository;

@Configuration
@ComponentScan(basePackageClasses = {UserRepository.class, MangaRepository.class})
public class SpringDataJpaAdapterConfiguration {

    @Bean
    public UserSpringJpaAdapater userSpringJpaAdapater(UserRepository userRepository) {
        return new UserSpringJpaAdapater(userRepository);
    }
    @Bean
    public MangaSpringJpaAdapter mangaSpringJpaAdapter(MangaRepository mangaRepository) {
        return new MangaSpringJpaAdapter(mangaRepository);
    }
}
