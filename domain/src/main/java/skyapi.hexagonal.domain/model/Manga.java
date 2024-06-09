package skyapi.hexagonal.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name="MANGAS")
public class Manga {
    @Id
    @GeneratedValue
    @Column(name="ID")
    private Long id;

    @Column(name="TITLE")
    private String title;

    @Column(name="DESCRIPTION")
    private String description;

    @ManyToOne(fetch = FetchType.LAZY,targetEntity=MangaCategory.class)
    @Column(name="CATEGORY")
    private MangaCategory category;

    @ManyToOne(fetch = FetchType.LAZY,targetEntity=Manga.class)
    @Column(name="AUTHOR")
    private Author author;

    @ManyToOne(fetch = FetchType.LAZY,targetEntity=Manga.class)
    @Column(name="EDITORIAL")
    private Editorial editorial;

    @OneToMany(fetch = FetchType.LAZY,targetEntity=Manga.class)
    @Column(name="VOLUMES")
    private List<Volume> volume;

    public Long getEditorialId(){
        return editorial.getId();
    }
    public Long getCategoryId(){
        return category.getId();
    }
    public Long getAuthorId(){
        return author.getId();
    }
    public List<Volume> getVolumes(){
        List<Long> volumeIds = new ArrayList<>();
        volume.forEach(x->{
            volumeIds.add(x.getId());
        });
    }
}
