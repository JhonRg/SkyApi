package skyapi.hexagonal.in.api;

import org.springframework.stereotype.Component;
import skyapi.hexagonal.domain.model.Manga;
import skyapi.hexagonal.dto.MangaDTO;
import skyapi.hexagonal.in.service.MangaService;
import skyapi.hexagonal.mappers.GenericMapper;
import skyapi.hexagonal.out.persistence.adapter.MangaPersistenceAdapter;

import java.util.List;

@Component
public interface MangaServiceController  {
    public List<Manga> listMangas();
    public Manga getManga(Long id);
    public Manga addManga(MangaDTO manga);
}
