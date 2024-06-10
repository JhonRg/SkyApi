package skyapi.hexagonal.application.common;

import skyapi.hexagonal.domain.model.Author;
import skyapi.hexagonal.domain.model.Editorial;
import skyapi.hexagonal.domain.model.Manga;
import skyapi.hexagonal.domain.model.MangaCategory;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MangaTestCase {
    public static List<Manga> getListOfMangas(int size){
        List<Manga> mangaList = new ArrayList<>(size);
        Random random = new Random();
        for(int i = 0; i < size; i++){
            mangaList.add(Manga.builder()
                    .id(random.nextLong())
                    .title("Mangas for testcase")
                    .description("Descrpition for test")
                    .author(Author.builder()
                            .firstname("author")
                            .lastname("test").build())
                    .volume(new ArrayList<>())
                    .editorial(Editorial.builder()
                            .id(random.nextLong())
                            .name("Test Editorial")
                            .build())
                    .category(MangaCategory.builder()
                            .id(random.nextLong())
                            .name("Test Category")
                            .build())
                    .build());
        }
        return mangaList;
    }
}
