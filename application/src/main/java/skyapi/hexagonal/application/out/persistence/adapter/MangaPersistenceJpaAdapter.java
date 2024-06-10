package skyapi.hexagonal.out.persistence.adapter;

import skyapi.hexagonal.domain.model.Manga;
import skyapi.hexagonal.domain.ports.out.MangaPersistencePort;

import java.util.List;

public class MangaPersistenceJpaAdapter implements MangaPersistencePort {

    private final MangaPersistencePort mangaRepositoryJpaAdapter;
    public MangaPersistenceJpaAdapter(MangaPersistencePort mangaRepositoryJpaAdapter){
        this.mangaRepositoryJpaAdapter = mangaRepositoryJpaAdapter;
    }

    @Override
    public List<Manga> getAllMangas() {
        return mangaRepositoryJpaAdapter.getAllMangas();
    }

    @Override
    public Manga create(Manga manga) {
        Manga response = Manga.builder().build();
        return mangaRepositoryJpaAdapter.create(manga);
    }

    @Override
    public Manga read(Long id) {
        Manga response = Manga.builder().build();
        return mangaRepositoryJpaAdapter.read(id);
    }

    //TODO: Revisar el porque necesita Long, si los ID's los creamos en negocio? o no?
    @Override
    public Manga update(Long id, Manga manga) {
        return mangaRepositoryJpaAdapter.update(id, manga);
    }

    @Override
    public void delete(Long id) {
         mangaRepositoryJpaAdapter.delete(id);
    }
}
