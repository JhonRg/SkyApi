package skyapi.hexagonal.common;

import org.springframework.beans.BeanUtils;
import skyapi.hexagonal.application.dto.MangaDTO;
import skyapi.hexagonal.domain.model.Author;
import skyapi.hexagonal.domain.model.Editorial;
import skyapi.hexagonal.domain.model.Manga;
import skyapi.hexagonal.domain.model.MangaCategory;

public class MangaTestCase {
    protected Manga getMangaForTest(){
        double id_random = Math.random()*1000;
        return Manga.builder()
                .id((long)id_random)
                .title("My Hero Academia")
                .description("Manga de super héroes")
                .editorial(Editorial.builder().id(1L).name("Planeta Cómic").build())
                .author(Author.builder().id(1L).firstname("Kohei").lastname("Horikoshi").build())
                .category(MangaCategory.builder().id(1L).name("Shonen").build())
                .volume(null)
                .build();
    }
    protected MangaDTO getMangaDTOForTest(){
        MangaDTO dto = MangaDTO.builder().build();
        BeanUtils.copyProperties(getMangaForTest(), dto);
        return dto;
    }
}
