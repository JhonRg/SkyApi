package skyapi.hexagonal.application.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import java.util.List;

@Data
@AllArgsConstructor
@Builder
public class MangaCategoryDTO {
    private Integer id;
    private String name;
    private List<Long> mangaIds; // Lista de ids de mangas
}