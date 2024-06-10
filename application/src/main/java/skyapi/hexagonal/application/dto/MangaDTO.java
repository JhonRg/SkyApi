package skyapi.hexagonal.application.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
@Builder
public class MangaDTO {
    private Long id;
    private String title;
    private String description;
    private Long categoryId; // Id de la categoría
    private Long authorId; // Id del autor
    private Long editorialId; // Id de la editorial
    private List<Long> volumeIds; // Lista de ids de volúmenes
}