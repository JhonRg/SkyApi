package skyapi.hexagonal.persistence.jpa.adapters;

import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import skyapi.hexagonal.out.persistence.api.MangaRepositoryAdapter;
import skyapi.hexagonal.domain.model.Manga;
import skyapi.hexagonal.persistence.jpa.entities.MangaEntity;
import skyapi.hexagonal.persistence.jpa.mappers.GenericMapper;
import skyapi.hexagonal.persistence.jpa.mappers.MangaMapper;
import skyapi.hexagonal.persistence.jpa.repositories.MangaRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MangaSpringJpaAdapter implements MangaRepositoryAdapter {

    private final MangaRepository mangaRepository;
    public MangaSpringJpaAdapter(MangaRepository mangaRepository) {
        this.mangaRepository = mangaRepository;
    }

    @Override
    public List<Manga> getAllMangas() {
        List<Manga> responseModel = new ArrayList<>();
        Manga _manga = Manga.builder().build();
        List<MangaEntity> responseEntities = mangaRepository.findAll();
        for (MangaEntity mangaEntity : responseEntities) {
            GenericMapper.toModel(_manga, mangaEntity);
            responseModel.add(_manga);
        }
        return responseModel;
    }

    @Override
    public Manga create(Manga manga) {
        Manga response = Manga.builder().build();
        MangaEntity savedEntity;

        Optional<MangaEntity> responseEntity = mangaRepository.findById(manga.getId());
        if(responseEntity.isEmpty()){
            savedEntity = mangaRepository.save(MangaMapper.fromModelToEntity(manga));
            return MangaMapper.fromEntityToModel(savedEntity);
        }else{
            throw new EntityExistsException("Manga with id " + manga.getId() + " already exists");
        }
    }

    @Override
    public Manga read(Long id) {
        Manga _manga = Manga.builder().build();

        Optional<MangaEntity> response = mangaRepository.findById(id);
        MangaEntity _entity = response.orElse(null);

        if(response.isPresent()){
             GenericMapper.toModel(_manga, _entity);
             return _manga;
        }else{
            throw new EntityNotFoundException("Manga with id " + id + " not found");
        }

    }

    @Override
    public Manga update(Long id, Manga manga) {
        Optional<MangaEntity> response = mangaRepository.findById(id);
        if(response.isPresent()){
            return GenericMapper.toModel(Manga.builder().build(), manga);
        }else{
            throw new EntityNotFoundException("Manga with id " + id + " not found");
        }
        }

    @Override
    public void delete(Long id) {
        Optional<MangaEntity> target = mangaRepository.findById(id);
        if(target.isPresent()){
            mangaRepository.delete(target.get());
        }else{
            throw new EntityNotFoundException("Manga with id " + id + " not found");
        }
    }
}
