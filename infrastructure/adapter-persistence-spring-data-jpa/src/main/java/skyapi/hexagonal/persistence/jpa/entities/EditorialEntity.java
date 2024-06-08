package skyapi.hexagonal.persistence.jpa.entities;

import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "EDITORIALS", schema = "PUBLIC")
public class EditorialEntity {
    @Id
    @Column(name = "ID", nullable = false)
    private Integer id;

    @Lob
    @Column(name = "NAME", nullable = false)
    private String name;

}