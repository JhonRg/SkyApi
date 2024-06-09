package skyapi.hexagonal.infrastructure.rest.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import skyapi.hexagonal.domain.model.Manga;
import skyapi.hexagonal.dto.MangaDTO;
import skyapi.hexagonal.in.api.MangaServiceController;

import java.util.List;

@RestController
//@RequestMapping
public class MangaController {

    private MangaServiceController mangaController;
    public MangaController(MangaServiceController mangaController){
        this.mangaController = mangaController;
    }
    @GetMapping("/library")
    public ResponseEntity<List<Manga>> listMangas() {
        ResponseEntity<List<Manga>> response = ResponseEntity.ok(mangaController.listMangas());
        return response;
    }

    @GetMapping("/manga/{id}")
    public ResponseEntity<Manga> getManga(@RequestParam Long id) {
        ResponseEntity<Manga> response = ResponseEntity.ok(mangaController.getManga(id));
        return response;
    }

    @PostMapping("/addManga")
    public ResponseEntity<Manga> addManga(MangaDTO manga) {
        return ResponseEntity.ok(mangaController.addManga(manga));
    }
}
