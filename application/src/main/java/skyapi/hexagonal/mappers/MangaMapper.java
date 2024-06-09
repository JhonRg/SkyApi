package skyapi.hexagonal.mappers;

import skyapi.hexagonal.domain.model.*;
import skyapi.hexagonal.dto.MangaDTO;

import java.util.ArrayList;

public class MangaMapper implements GenericMapper<Manga, MangaDTO> {

    public static MangaDTO fromModelToDto(Manga model) {
        if(model == null) return MangaDTO.builder().build();
        MangaDTO dto = MangaDTO.builder().build();
        GenericMapper.fromModelToDto(dto, model);
        mapMangaAggregateFromModel(dto, model);
        return dto;
    }

    /**
     *
     * @param dto dto object who wanna copy
     * @return Equivalent model or a void one if dto its null
     */
    public static Manga fromDtoToModel(MangaDTO dto) {
        Manga response = Manga.builder().build();
        if(dto == null) return response;
        GenericMapper.fromDtoToModel(response, dto);
        mapMangaAggregateFromDto(response, dto);
        return response;
    }
    private static void mapMangaAggregateFromModel(MangaDTO dto, Manga model){
        if(model.getCategory()!=null){
            mapCategory(dto, model);
        }else{
            dto.setCategoryId(null);
        }
        if(model.getEditorial()!=null){
            mapEditorial(dto, model);
        }else{
            dto.setEditorialId(null);
        }
        if(model.getVolume()!=null){
            mapVolumes(dto, model);
        }else{
            dto.setVolumeIds(null);
        }
        if(model.getAuthor()!=null){
            mapAuthor(dto, model);
        }else{
            dto.setAuthorId(null);
        }
    }
    private static void mapMangaAggregateFromDto(Manga model, MangaDTO dto){
        if(dto.getCategoryId()!=null){
            mapCategory(dto, model);
        }else{
            model.setCategory(null);
        }
        if(dto.getEditorialId()!=null){
            mapEditorial(dto, model);
        }else{
            model.setEditorial(null);
        }
        if(dto.getVolumeIds()!=null){
            mapVolumes(dto, model);
        }else{
            model.setVolume(null);
        }
        if(dto.getAuthorId()!=null){
            mapAuthor(dto, model);
        }else{
            model.setAuthor(null);
        }
    }
    private static void mapCategory(MangaDTO dto, Manga model){
        if(dto.getCategoryId()==null){
            dto.setCategoryId(model.getCategoryId());
        } else if (model.getCategory()==null) {
            model.setCategory(MangaCategory.builder()
                    .id(dto.getCategoryId())
                    .build());
        }
    }
    private static void mapEditorial(MangaDTO dto, Manga model){
        dto.setEditorialId(model.getEditorialId());
    }
    private static void mapVolumes(MangaDTO dto, Manga model){
        if(dto.getVolumeIds()==null){
            dto.setVolumeIds(new ArrayList<>());
            model.getVolume().forEach(x -> dto.getVolumeIds().add(x.getId()));
        } else if (model.getVolume()==null) {
            model.setVolume(new ArrayList<>());
            dto.getVolumeIds().forEach(x-> {
                Volume volume = Volume.builder().id(x).build();
                model.getVolume().add(volume);
            });
        }
    }
    private static void mapAuthor(MangaDTO dto, Manga model){
        if(dto.getAuthorId()==null){
            dto.setAuthorId(model.getAuthorId());
        }else if (model.getAuthor()==null) {
            model.setAuthor(Author.builder().id(dto.getId()).build());
        }
    }
}
