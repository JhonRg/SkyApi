package skyapi.hexagonal.application.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@Builder
public class AuthorDTO {
    private Integer id;
    private String firstname;
    private String lastname;
    private LocalDate birthdate;
    private List<Long> publishedMangaIds; // Lista de ids de mangas publicados
}