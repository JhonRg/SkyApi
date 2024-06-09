package skyapi.hexagonal.in.api;

import org.springframework.stereotype.Component;
import skyapi.hexagonal.dto.MangaDTO;

import java.util.List;

@Component
public interface MangaServiceController  {
    public List<MangaDTO> listMangas();
    public MangaDTO getManga(Long id);
    public MangaDTO addManga(MangaDTO manga);
}
