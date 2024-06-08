package skyapi.hexagonal.persistence.jpa.entities;

import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "CATEGORIES", schema = "PUBLIC")
public class CategoryEntity {
    @Id
    @Column(name = "ID", nullable = false)
    private Integer id;

    @Lob
    @Column(name = "NAME", nullable = false)
    private String name;

}