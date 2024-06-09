package skyapi.hexagonal.in.service;

import skyapi.hexagonal.domain.model.Manga;
import skyapi.hexagonal.dto.MangaDTO;

import java.util.List;

public interface MangaService {
    public List<Manga> listMangas();
    public Manga getManga(Long id);
    public Manga addManga(Manga manga);
}
