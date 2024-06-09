package skyapi.hexagonal.in.api.impl;

import org.springframework.stereotype.Component;
import skyapi.hexagonal.domain.model.Manga;
import skyapi.hexagonal.dto.MangaDTO;
import skyapi.hexagonal.in.api.MangaServiceController;
import skyapi.hexagonal.in.service.MangaService;
import skyapi.hexagonal.in.service.impl.MangaServiceImpl;
import skyapi.hexagonal.mappers.GenericMapper;
import skyapi.hexagonal.out.persistence.adapter.MangaPersistenceAdapter;
import skyapi.hexagonal.out.persistence.api.MangaRepositoryAdapter;

import java.util.List;

@Component
public class MangaServiceControllerImpl implements MangaServiceController {

    MangaService service;

    public MangaServiceControllerImpl(MangaService service) {this.service = service;}
    @Override
    public List<Manga> listMangas() {
        return service.listMangas();
    }

    @Override
    public Manga getManga(Long id) {
        return service.getManga(id);
    }

    @Override
    public Manga addManga(MangaDTO manga) {
        Manga model = GenericMapper.toModel(Manga.builder().build(), manga);
        return service.addManga(model);
    }
}