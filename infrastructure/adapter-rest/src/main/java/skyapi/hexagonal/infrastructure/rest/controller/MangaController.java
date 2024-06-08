package skyapi.hexagonal.infrastructure.rest.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import skyapi.hexagonal.domain.model.Manga;
import skyapi.hexagonal.in.controllerRest.MangaRestController;

import java.util.List;

@RestController
//@RequestMapping
public class MangaController {

    private MangaRestController mangaController;
    public MangaController(MangaRestController mangaController){
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
    public ResponseEntity<Manga> addManga(Manga manga) {
        return ResponseEntity.ok(mangaController.addManga(manga));
    }
}
