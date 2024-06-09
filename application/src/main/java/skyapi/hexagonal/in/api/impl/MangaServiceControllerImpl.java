package skyapi.hexagonal.in.api.impl;

import org.springframework.stereotype.Component;
import skyapi.hexagonal.domain.model.Manga;
import skyapi.hexagonal.dto.MangaDTO;
import skyapi.hexagonal.in.api.MangaServiceController;
import skyapi.hexagonal.in.service.impl.MangaServiceImpl;
import skyapi.hexagonal.mappers.MangaMapper;

import java.util.ArrayList;
import java.util.List;

@Component
public class MangaServiceControllerImpl implements MangaServiceController {

    MangaServiceImpl service;

    public MangaServiceControllerImpl(MangaServiceImpl service) {this.service = service;}
    @Override
    public List<MangaDTO> listMangas() {
        List<MangaDTO> response = new ArrayList<>();

        service.listMangas().forEach(x-> response.add(MangaMapper.fromModelToDto(x)));

        return response;
    }

    @Override
    public MangaDTO getManga(Long id) {
        return MangaMapper.fromModelToDto(service.getManga(id));
    }

    @Override
    public MangaDTO addManga(MangaDTO manga) {
        Manga savedModel = service.addManga(MangaMapper.fromDtoToModel(manga));
        return MangaMapper.fromModelToDto(savedModel);
    }
}