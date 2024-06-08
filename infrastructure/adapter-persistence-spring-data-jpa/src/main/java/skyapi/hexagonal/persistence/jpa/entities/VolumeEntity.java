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
@Table(name = "VOLUMES", schema = "PUBLIC")
public class VolumeEntity {
    @Id
    @Column(name = "ID", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.RESTRICT)
    @JoinColumn(name = "CHAPTER_ID")
    private ChapterEntity chapter;

    @Column(name = "VOLUME_NUMBER")
    private Integer volumeNumber;

/*
 TODO [Reverse Engineering] create field to map the 'COVER' column
 Available actions: Define target Java type | Uncomment as is | Remove column mapping
    @Column(name = "COVER", columnDefinition = "BINARY LARGE OBJECT")
    private Object cover;
*/
/*
 TODO [Reverse Engineering] create field to map the 'EPILOG' column
 Available actions: Define target Java type | Uncomment as is | Remove column mapping
    @Column(name = "EPILOG", columnDefinition = "BINARY LARGE OBJECT")
    private Object epilog;
*/
}