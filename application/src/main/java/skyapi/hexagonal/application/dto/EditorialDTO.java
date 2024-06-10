package skyapi.hexagonal.application.dto;

import lombok.Builder;
import lombok.Data;
import lombok.AllArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@Builder
public class EditorialDTO {
    private Integer id;
    private String name;
    private List<Long> publishedMangaIds; // Lista de ids de mangas publicados
}