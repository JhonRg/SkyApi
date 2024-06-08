package skyapi.hexagonal.persistence.jpa.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "PAGES", schema = "PUBLIC")
public class PageEntity {
    @Id
    @Column(name = "ID", nullable = false)
    private Integer id;

    @Column(name = "PAGE_NUMBER", nullable = false)
    private Integer pageNumber;

}