package skyapi.hexagonal.application.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import java.util.List;

@Data
@AllArgsConstructor
@Builder
public class ChapterDTO {
    private Integer id;
    private Integer chapterNumber;
    private String title;
    private Long volumeId; // Id del volumen
    private List<Long> pageIds; // Lista de ids de páginas
}
