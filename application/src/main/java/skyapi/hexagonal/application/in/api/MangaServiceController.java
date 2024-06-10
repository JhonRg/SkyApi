package skyapi.hexagonal.application.in.api;

import skyapi.hexagonal.application.dto.MangaDTO;

import java.util.List;
@SuppressWarnings("unused")
public interface MangaServiceController {
    List<MangaDTO> listMangas();
    MangaDTO getManga(Long id);
    MangaDTO addManga(MangaDTO dto);
}
