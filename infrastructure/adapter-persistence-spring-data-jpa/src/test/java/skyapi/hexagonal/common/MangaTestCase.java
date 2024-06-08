package skyapi.hexagonal.common;

import org.springframework.beans.BeanUtils;
import skyapi.hexagonal.domain.model.Author;
import skyapi.hexagonal.domain.model.Editorial;
import skyapi.hexagonal.domain.model.Manga;
import skyapi.hexagonal.domain.model.MangaCategory;
import skyapi.hexagonal.persistence.jpa.entities.MangaEntity;

public class MangaTestCase {
    protected Manga getMangaForTest(){
        double id_random = Math.random()*1000;
        return Manga.builder()
                .id((long)id_random)
                .title("My Hero Academia")
                .description("Manga de super héroes")
                .editorial(Editorial.builder().id(1).name("Planeta Cómic").build())
                .author(Author.builder().id(1).firstname("Kohei").lastname("Horikoshi").build())
                .category(MangaCategory.builder().id(1).name("Shonen").build())
                .volume(null)
                .build();
    }
    protected MangaEntity getMangaEntityForTest(){
        MangaEntity entity = MangaEntity.builder().build();
        BeanUtils.copyProperties(getMangaForTest(), entity);
        return entity;
    }
}
