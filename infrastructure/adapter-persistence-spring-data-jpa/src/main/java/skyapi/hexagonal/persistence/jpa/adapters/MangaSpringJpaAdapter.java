package skyapi.hexagonal.persistence.jpa.adapters;

import skyapi.hexagonal.out.persistence.api.MangaRepositoryAdapter;
import skyapi.hexagonal.domain.model.Manga;
import skyapi.hexagonal.persistence.jpa.repositories.MangaRepository;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

public class MangaSpringJpaAdapter implements MangaRepositoryAdapter {

    private final MangaRepository mangaRepository;
    public MangaSpringJpaAdapter(MangaRepository mangaRepository) {
        this.mangaRepository = mangaRepository;
    }

    @Override
    public List<Manga> getAllMangas() {
        return mangaRepository.findAll();
    }

    @Override
    public Manga create(Manga manga) {
        Manga response = Manga.builder().build();
        Manga savedEntity;

        Optional<Manga> responseEntity = mangaRepository.findById(manga.getId());
        if(responseEntity.isEmpty()){
            return responseEntity.orElse(Manga.builder().build());
        }else{
            throw new EntityExistsException("Manga with id " + manga.getId() + " already exists");
        }
    }

    @Override
    public Manga read(Long id) {
        Optional<Manga> response = mangaRepository.findById(id);
        if(response.isPresent()){
             return response.get();
        }else{
            throw new EntityNotFoundException("Manga with id " + id + " not found");
        }
    }

    @Override
    public Manga update(Long id, Manga manga) {
        Optional<Manga> response = mangaRepository.findById(id);
        if(response.isPresent()){
            return response.get();
        }else{
            throw new EntityNotFoundException("Manga with id " + id + " not found");
        }
        }

    @Override
    public void delete(Long id) {
        Optional<Manga> target = mangaRepository.findById(id);
        if(target.isPresent()){
            mangaRepository.delete(target.get());
        }else{
            throw new EntityNotFoundException("Manga with id " + id + " not found");
        }
    }
}
