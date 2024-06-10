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
@Table(name="CATEGORIES", schema = "PUBLIC")
public class MangaCategory {
    @Id
    @GeneratedValue
    @Column(name="ID")
    private Long id;

    @Column(name="NAME")
    private String name;

    @OneToMany(mappedBy = "MANGAS", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Manga> mangas;
}
