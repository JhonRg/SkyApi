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
@Table(name = "CHAPTERS", schema = "PUBLIC")
public class ChapterEntity {
    @Id
    @Column(name = "ID", nullable = false)
    private Integer id;

    @Column(name = "CHAPTER_NUMBER", nullable = false)
    private Integer chapterNumber;

    @Column(name = "TITLE")
    private Integer title;

    @ManyToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.RESTRICT)
    @JoinColumn(name = "PAGES_ID")
    private PageEntity pages;

}