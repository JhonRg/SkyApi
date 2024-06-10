package skyapi.hexagonal.infrastructure.rest.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import skyapi.hexagonal.dto.MangaDTO;
import skyapi.hexagonal.application.in.api.MangaServiceController;

import java.util.List;

@RestController
//@RequestMapping
public class MangaControllerImpl implements MangaController{

    private final MangaServiceController mangaController;
    public MangaControllerImpl(MangaServiceController mangaController){
        this.mangaController = mangaController;
    }
    @GetMapping("/library")
    public ResponseEntity<List<MangaDTO>> listMangas() {
        return ResponseEntity.ok(mangaController.listMangas());
    }

    @GetMapping("/manga/{id}")
    public ResponseEntity<MangaDTO> getManga(@RequestParam Long id) {
        return ResponseEntity.ok(mangaController.getManga(id));
    }

    @PostMapping("/addManga")
    public ResponseEntity<MangaDTO> addManga(MangaDTO manga) {
        return ResponseEntity.ok(mangaController.addManga(manga));
    }
}
