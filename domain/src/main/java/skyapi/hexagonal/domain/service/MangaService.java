package skyapi.hexagonal.domain.service;

import skyapi.hexagonal.domain.model.Manga;

import java.util.List;

public interface MangaService {
    List<Manga> listMangas();
    Manga getManga(Long id);
    Manga addManga(Manga manga);
}