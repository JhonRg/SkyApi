package skyapi.hexagonal.application.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import java.util.List;

@Data
@AllArgsConstructor
@Builder
public class VolumeDTO {
    private Integer id;
    private List<Long> chapterIds; // Lista de ids de capítulos
    private String volumeNumber;
    private String epilogUrl;
    private String coverUrl;
    private Long mangaId; // Id del manga al que pertenece el volumen
}
