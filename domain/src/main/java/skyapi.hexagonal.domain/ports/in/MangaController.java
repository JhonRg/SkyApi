package skyapi.hexagonal.domain.ports.in;

import skyapi.hexagonal.domain.model.Manga;

import java.util.List;

public interface MangaController {
    List<Manga> listMangas();
    Manga getManga(Long id);
    Manga addManga(Manga manga);
}
