package skyapi.hexagonal.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
@Builder
public class Manga {
    private Long id;
    private String title;
    private String description;
    private MangaCategory category;
    private Author author;
    private Editorial editorial;
    private List<Volume> volume;
}
