package skyapi.hexagonal.domain.ports.out;


import skyapi.hexagonal.domain.model.Manga;

import java.util.List;

public interface MangaPersistencePort extends GenericPersistencePort<Manga, Long>{
//    public Manga getMangaResume(Long id);
//    public Manga addMangaResume(Manga manga);
    List<Manga> getAllMangas();
}
