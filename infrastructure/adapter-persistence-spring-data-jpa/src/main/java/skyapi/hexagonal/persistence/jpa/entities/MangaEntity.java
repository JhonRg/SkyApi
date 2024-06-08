package skyapi.hexagonal.persistence.jpa.entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "MANGAS", schema = "PUBLIC")
public class MangaEntity {
    @Id
    @Lob
    @Column(name = "ID", nullable = false)
    private Long id;

    @Lob
    @Column(name = "TITLE", nullable = false)
    private String title;

    @Lob
    @Column(name = "DESCRIPTION")
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "CATEGORY_ID")
    private CategoryEntity categoryEntity;

    @ManyToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.RESTRICT)
    @JoinColumn(name = "AUTHOR_ID")
    private AuthorEntity authorEntity;

    @ManyToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.RESTRICT)
    @JoinColumn(name = "EDITORIAL_ID")
    private EditorialEntity editorialEntity;

    @ManyToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.RESTRICT)
    @JoinColumn(name = "VOLUMES_ID")
    private VolumeEntity volumes;

}