package skyapi.hexagonal.persistence.jpa.mappers;

import org.springframework.beans.BeanUtils;
import skyapi.hexagonal.domain.model.Author;
import skyapi.hexagonal.domain.model.Editorial;
import skyapi.hexagonal.domain.model.Manga;
import skyapi.hexagonal.domain.model.MangaCategory;
import skyapi.hexagonal.persistence.jpa.entities.*;

import java.util.ArrayList;

public class MangaMapper {

    public static MangaEntity fromModelToEntity(Manga manga) {
        if(manga == null) return MangaEntity.builder().build();
        MangaEntity mangaEntity = MangaEntity.builder().build();
        GenericMapper.fromModel(mangaEntity, manga);
        mapMangaAggregateFromModel(mangaEntity, manga);
        return mangaEntity;
    }
    public static Manga fromEntityToModel(MangaEntity entity) {
        if(entity == null) return Manga.builder().build();
        Manga manga = Manga.builder().build();
        GenericMapper.toModel(manga, entity);
        mapMangaAggregateFromEntity(manga, entity);
        return manga;
    }
    private static void mapMangaAggregateFromModel(MangaEntity entity, Manga model){
        if(model.getCategory()!=null){
            mapCategory(entity, model);
        }else{
            entity.setCategoryEntity(null);
        }
        if(model.getEditorial()!=null){
            mapEditorial(entity, model);
        }else{
            entity.setEditorialEntity(null);
        }
        if(model.getVolume()!=null){
            mapVolumes(entity, model);
        }else{
            entity.setVolumes(null);
        }
        if(model.getAuthor()!=null){
            mapAuthor(entity, model);
        }else{
            entity.setAuthorEntity(null);
        }
    }
    private static void mapMangaAggregateFromEntity(Manga model, MangaEntity entity){
        if(entity.getCategoryEntity()!=null){
            mapCategory(entity, model);
        }else{
            model.setCategory(null);
        }
        if(entity.getEditorialEntity()!=null){
            mapEditorial(entity, model);
        }else{
            model.setEditorial(null);
        }
        if(entity.getVolumes()!=null){
            mapVolumes(entity, model);
        }else{
            model.setVolume(null);
        }
        if(entity.getAuthorEntity()!=null){
            mapAuthor(entity, model);
        }else{
            model.setAuthor(null);
        }
    }
    private static void mapCategory(MangaEntity e, Manga m){
        if(e.getCategoryEntity()==null){
            e.setCategoryEntity(CategoryEntity.builder().build());
            BeanUtils.copyProperties(m.getCategory(), e.getCategoryEntity());
        } else if (m.getCategory()==null) {
            m.setCategory(MangaCategory.builder().build());
            BeanUtils.copyProperties(e.getCategoryEntity(), m.getCategory());
        }

    }
    private static void mapEditorial(MangaEntity e, Manga m){
        if(e.getEditorialEntity()==null){
            e.setEditorialEntity(EditorialEntity.builder().build());
            BeanUtils.copyProperties(e.getEditorialEntity(), m.getEditorial());
        }else if(m.getEditorial()==null) {
            m.setEditorial(Editorial.builder().build());
            BeanUtils.copyProperties(m.getEditorial(), e.getEditorialEntity() );
        }

    }
    private static void mapVolumes(MangaEntity e, Manga m){
        if(e.getVolumes()==null){
            e.setVolumes(VolumeEntity.builder().build());
            BeanUtils.copyProperties(e.getVolumes(), m.getVolume());
        } else if (m.getVolume()==null) {
            m.setVolume(new ArrayList<>());
            BeanUtils.copyProperties(m.getVolume(), e.getVolumes());
        }
    }
    private static void mapAuthor(MangaEntity e, Manga m){
        if(e.getAuthorEntity()==null){
            e.setAuthorEntity(AuthorEntity.builder().build());
            BeanUtils.copyProperties(e.getAuthorEntity(), m.getAuthor());
        }else if (m.getAuthor()==null) {
            m.setAuthor(Author.builder().build());
            BeanUtils.copyProperties(m.getAuthor(), e.getAuthorEntity());
        }
    }
}
