package skyapi.hexagonal.domain.service;

import org.springframework.stereotype.Service;
import skyapi.hexagonal.domain.model.Manga;

import java.util.List;

@Service
public interface MangaService {
    List<Manga> listMangas();
    Manga getManga(Long id);
    Manga addManga(Manga manga);
}
