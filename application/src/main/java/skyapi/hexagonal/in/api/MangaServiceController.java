package skyapi.hexagonal.in.api;

import org.springframework.stereotype.Component;
import skyapi.hexagonal.dto.MangaDTO;

import java.util.List;

@Component
public interface MangaServiceController  {
    List<MangaDTO> listMangas();
    MangaDTO getManga(Long id);
    MangaDTO addManga(MangaDTO manga);
}
