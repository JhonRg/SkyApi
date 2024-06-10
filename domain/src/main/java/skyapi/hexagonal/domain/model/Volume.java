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
@Table(name="VOLUMES", schema="PUBLIC")
public class Volume {
    @Id
    @GeneratedValue
    private Long id;

    @OneToMany(mappedBy = "VOLUMES", targetEntity = Chapter.class, fetch = FetchType.EAGER)
    private List<Chapter> chapter;

    @Column(name="VOLUME_NUMBER")
    private String volumeNumber;

    @Column(name="EPILOG")
    private String epilogUrl;

    @Column(name="COVER")
    private String coverUrl;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Manga.class)
    private Manga manga;

}
