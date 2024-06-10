package skyapi.hexagonal.domain.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@SuppressWarnings("unused")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="AUTHORS")
public class Author {
    @Id
    @GeneratedValue
    @Column(name="ID", nullable=false)
    private Long id;

    @Lob
    @Column(name = "FIRSTNAME", nullable = false)
    private String firstname;

    @Lob
    @Column(name = "LASTNAME", nullable = false)
    private String lastname;

    @Column(name = "BIRTHDAY")
    private LocalDate birthdate;

    @OneToMany(targetEntity = Manga.class)
    private List<Manga> publishedMangas;
}
