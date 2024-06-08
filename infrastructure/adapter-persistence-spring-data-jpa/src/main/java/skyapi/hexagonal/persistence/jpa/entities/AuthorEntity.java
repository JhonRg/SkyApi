package skyapi.hexagonal.persistence.jpa.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "AUTHORS", schema = "PUBLIC")
public class AuthorEntity {
    @Id
    @Column(name = "ID", nullable = false)
    private Integer id;

    @Lob
    @Column(name = "FIRSTNAME", nullable = false)
    private String firstname;

    @Lob
    @Column(name = "LASTNAME", nullable = false)
    private String lastname;

    @Column(name = "BIRTHDAY")
    private LocalDate birthday;

}