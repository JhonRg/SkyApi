package skyapi.hexagonal.persistence.jpa.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import skyapi.hexagonal.domain.model.User;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name="USER")
public class UserEntity {

    @Id
    String id;
    @Column
    String username;
    @Column
    String password;
    @Column(columnDefinition = "TIMESTAMP")
    LocalDateTime createdAt;

    public static UserEntity fromUser(User user){
        return UserEntity.builder()
                .id(user.getId().toString())
                .username(user.getUsername())
                .password(user.getPassword())
                .build();
    }
    public User toUser(){
        return User.builder()
                .id(UUID.fromString(this.getId()))
                .username(this.getUsername())
                .password(this.getPassword())
                .build();
    }
}
