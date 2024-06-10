package skyapi.hexagonal.domain.ports.out;


import skyapi.hexagonal.domain.model.Manga;

import java.util.List;

public interface MangaPersistencePort extends GenericPersistencePort<Manga, Long>{
    List<Manga> getAllMangas();
}
