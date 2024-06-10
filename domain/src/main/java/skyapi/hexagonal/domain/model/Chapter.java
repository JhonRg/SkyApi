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
@Table(name="CHAPTERS", schema ="PUBLIC")
public class Chapter {
    @Id
    @Column(name = "ID", nullable = false)
    private Long id;

    @Column(name = "CHAPTER_NUMBER", nullable = false)
    private Integer chapterNumber;

    @Column(name = "TITLE")
    private String title;

    @ManyToOne(targetEntity = Volume.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "PAGES_ID")
    private Volume volume;

    @OneToMany
    private List<Page> pages;
}
