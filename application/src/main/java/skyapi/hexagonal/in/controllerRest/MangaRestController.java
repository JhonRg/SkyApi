package skyapi.hexagonal.in.controllerRest;

import org.springframework.stereotype.Component;
import skyapi.hexagonal.domain.model.Manga;
import skyapi.hexagonal.domain.service.MangaController;
import skyapi.hexagonal.domain.service.impl.MangaServiceImpl;

import java.util.List;

@Component
public class MangaRestController implements MangaController {

    MangaServiceImpl service;
    public MangaRestController(MangaServiceImpl service) {this.service = service;}
    @Override
    public List<Manga> listMangas() {
        return service.listMangas();
    }

    @Override
    public Manga getManga(Long id) {
        return service.getManga(id);
    }

    @Override
    public Manga addManga(Manga manga) {
        return service.addManga(manga);
    }
}
