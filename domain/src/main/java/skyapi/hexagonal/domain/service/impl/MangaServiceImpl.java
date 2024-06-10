package skyapi.hexagonal.domain.service.impl;


import org.springframework.stereotype.Service;
import skyapi.hexagonal.domain.model.Manga;
import skyapi.hexagonal.domain.service.MangaService;
import skyapi.hexagonal.domain.ports.out.MangaPersistencePort;

import java.util.List;


public class MangaServiceImpl implements MangaService {

    MangaPersistencePort repository;
    public MangaServiceImpl(MangaPersistencePort repository){this.repository = repository;}

    public List<Manga> listMangas(){
        return repository.getAllMangas();
    }

    public Manga getManga(Long id){
        return repository.read(id);
    }

    @Override
    public Manga addManga(Manga manga) {
        return repository.create(manga);
    }

}
