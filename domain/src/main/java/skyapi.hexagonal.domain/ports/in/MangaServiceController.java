package skyapi.hexagonal.domain.ports.in;

import skyapi.hexagonal.domain.model.Manga;

import java.util.List;

public interface MangaServiceController {
    List<Manga> listMangas();
    Manga getManga(Long id);
    Manga addManga(Manga manga);
}
