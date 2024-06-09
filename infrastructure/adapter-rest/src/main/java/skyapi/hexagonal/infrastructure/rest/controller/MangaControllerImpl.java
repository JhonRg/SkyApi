package skyapi.hexagonal.infrastructure.rest.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import skyapi.hexagonal.dto.MangaDTO;
import skyapi.hexagonal.in.api.MangaServiceController;

import java.util.List;

@RestController
//@RequestMapping
public class MangaControllerImpl implements MangaController{

    private MangaServiceController mangaController;
    public MangaControllerImpl(MangaServiceController mangaController){
        this.mangaController = mangaController;
    }
    @GetMapping("/library")
    public ResponseEntity<List<MangaDTO>> listMangas() {
        ResponseEntity<List<MangaDTO>> response = ResponseEntity.ok(mangaController.listMangas());
        return response;
    }

    @GetMapping("/manga/{id}")
    public ResponseEntity<MangaDTO> getManga(@RequestParam Long id) {
        ResponseEntity<MangaDTO> response = ResponseEntity.ok(mangaController.getManga(id));
        return response;
    }

    @PostMapping("/addManga")
    public ResponseEntity<MangaDTO> addManga(MangaDTO manga) {
        return ResponseEntity.ok(mangaController.addManga(manga));
    }
}
