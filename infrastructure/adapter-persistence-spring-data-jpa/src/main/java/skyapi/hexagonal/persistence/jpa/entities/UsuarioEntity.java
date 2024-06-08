package skyapi.hexagonal.persistence.jpa.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "USUARIO", schema = "PUBLIC")
public class UsuarioEntity {
    @Id
    @Lob
    @Column(name = "USER_ID", nullable = false)
    private String userId;

    @Lob
    @Column(name = "USERNAME", nullable = false)
    private String username;

    @Lob
    @Column(name = "PASSWORD", nullable = false)
    private String password;

    @Column(name = "CREATED_AT", nullable = false)
    private Instant createdAt;

}