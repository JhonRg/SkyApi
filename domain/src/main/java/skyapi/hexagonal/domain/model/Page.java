package skyapi.hexagonal.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@SuppressWarnings("unused")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="PAGES")
public class Page {
    @Id
    @GeneratedValue
    @Column(name="ID")
    private Long id;

    @Column(name="PAGE_NUMBERS")
    private Integer pageNumber;

    @Column(name="IMAGE_URL")
    private String imageUrl;

    @ManyToOne(targetEntity=Chapter.class, fetch=FetchType.EAGER)
    private Chapter chapter;
}
