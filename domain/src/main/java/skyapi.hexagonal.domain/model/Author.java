package skyapi.hexagonal.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Author {
    private Integer id;
    private String firstname;
    private String lastname;
    private LocalDate birthdate;
}
