package skyapi.hexagonal.domain.service.impl;


import org.springframework.stereotype.Service;
import skyapi.hexagonal.domain.model.Manga;
import skyapi.hexagonal.domain.ports.out.MangaPersistencePort;
import skyapi.hexagonal.domain.service.MangaService;

import java.util.List;

@Service
public class MangaServiceImpl implements MangaService {

    MangaPersistencePort repository;
    public MangaServiceImpl(MangaPersistencePort repository){this.repository = repository;}
    public List<Manga> listMangas(){
        return repository.getAllMangas();
    }
    public Manga getManga(Long id){
        return repository.read(id);
    }
    public Manga addManga(Manga manga){
        return repository.create(manga);
    }
}
