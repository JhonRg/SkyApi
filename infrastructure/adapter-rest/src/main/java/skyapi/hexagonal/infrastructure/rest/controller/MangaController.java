package skyapi.hexagonal.infrastructure.rest.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;
import skyapi.hexagonal.dto.MangaDTO;

import java.util.List;

public interface MangaController {
    ResponseEntity<List<MangaDTO>> listMangas();
    ResponseEntity<MangaDTO> getManga(@RequestParam Long id);
    ResponseEntity<MangaDTO> addManga(MangaDTO manga);
}