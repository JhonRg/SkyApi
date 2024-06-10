package skyapi.hexagonal.application.in.api;

import skyapi.hexagonal.application.dto.MangaDTO;

import java.util.List;

public interface MangaServiceController {
    public List<MangaDTO> listMangas();
    public MangaDTO getManga(Long id);
    public MangaDTO addManga(MangaDTO dto);
}
