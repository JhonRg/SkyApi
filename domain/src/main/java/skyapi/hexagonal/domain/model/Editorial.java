package skyapi.hexagonal.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@SuppressWarnings("unused")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="EDITORIALS")
public class Editorial {
    @Id
    @GeneratedValue
    @Column(name="ID")
    private Long id;

    @Column(name="NAME")
    private String name;

    @OneToMany(targetEntity = Manga.class, cascade = CascadeType.ALL)
    private List<Manga> publishedMangas;
}
