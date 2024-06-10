package skyapi.hexagonal.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class PageDTO {
    private Integer id;
    private Integer pageNumber;
    private String imageUrl;
    private Long chapterId; // Id del capítulo al que pertenece la página
}
