package skyapi.hexagonal.application.in.api.impl;

import org.springframework.stereotype.Service;
import skyapi.hexagonal.application.dto.MangaDTO;
import skyapi.hexagonal.application.in.api.MangaServiceController;
import skyapi.hexagonal.application.mappers.MangaMapper;
import skyapi.hexagonal.domain.model.Manga;
import skyapi.hexagonal.domain.service.MangaService;

import java.util.ArrayList;
import java.util.List;

@Service
public class MangaServiceControllerImpl implements MangaServiceController {

    MangaService service;
    public MangaServiceControllerImpl(MangaService service) {this.service = service;}

    @Override
    public List<MangaDTO> listMangas() {
        List<MangaDTO> mangas = new ArrayList<>();
        service.listMangas().forEach(manga -> {
            mangas.add(MangaMapper.fromModelToDto(manga));
        });
        return mangas;
    }

    @Override
    public MangaDTO getManga(Long id) {
        return MangaMapper.fromModelToDto(service.getManga(id));
    }

    @Override
    public MangaDTO addManga(MangaDTO dto) {
        Manga toSave = MangaMapper.fromDtoToModel(dto);
        service.addManga(toSave);
        return MangaMapper.fromModelToDto(toSave);
    }
}