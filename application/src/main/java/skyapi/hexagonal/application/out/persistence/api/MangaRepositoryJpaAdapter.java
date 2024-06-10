package skyapi.hexagonal.out.persistence.api;

import skyapi.hexagonal.domain.model.Manga;

import java.util.List;

public interface MangaRepositoryJpaAdapter {
    List<Manga> getAllMangas();
    Manga create(Manga manga);
    Manga read(Long id);
    Manga update(Long id, Manga manga);
    void delete(Long id);
}
