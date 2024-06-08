package skyapi.hexagonal.out.persistence.adapter;

import skyapi.hexagonal.out.persistence.api.MangaRepositoryAdapter;
import skyapi.hexagonal.domain.model.Manga;
import skyapi.hexagonal.domain.ports.out.MangaPersistencePort;

import java.util.List;

public class MangaPersistenceAdapter implements MangaPersistencePort {

    private final MangaRepositoryAdapter mangaRepositoryAdapter;
    public MangaPersistenceAdapter(MangaRepositoryAdapter mangaRepositoryAdapter){
        this.mangaRepositoryAdapter = mangaRepositoryAdapter;
    }

    @Override
    public List<Manga> getAllMangas() {
        return mangaRepositoryAdapter.getAllMangas();
    }

    @Override
    public Manga create(Manga manga) {
        Manga response = Manga.builder().build();
        return mangaRepositoryAdapter.create(manga);
    }

    @Override
    public Manga read(Long id) {
        Manga response = Manga.builder().build();
        return mangaRepositoryAdapter.read(id);
    }

    //TODO: Revisar el porque necesita Long, si los ID's los creamos en negocio? o no?
    @Override
    public Manga update(Long id, Manga manga) {
        return mangaRepositoryAdapter.update(id, manga);
    }

    @Override
    public void delete(Long id) {
         mangaRepositoryAdapter.delete(id);
    }
}
