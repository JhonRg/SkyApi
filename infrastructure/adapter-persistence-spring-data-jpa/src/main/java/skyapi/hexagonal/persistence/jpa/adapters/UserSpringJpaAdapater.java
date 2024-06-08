package skyapi.hexagonal.persistence.jpa.adapters;

import org.springframework.stereotype.Repository;
import skyapi.hexagonal.domain.model.User;
import skyapi.hexagonal.domain.ports.out.UserPersistencePort;
import skyapi.hexagonal.persistence.jpa.entities.UserEntity;
import skyapi.hexagonal.persistence.jpa.repositories.UserRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Repository
public class UserSpringJpaAdapater implements UserPersistencePort {

    private final UserRepository userRepository;
    public UserSpringJpaAdapater(UserRepository userRepository) {this.userRepository = userRepository;}

    @Override
    public User createUser(User user) {
        UserEntity userEntity = UserEntity.fromUser(user);
        userEntity.setCreatedAt(LocalDateTime.now());
        return userRepository.save(userEntity).toUser();
    }

    @Override
    public List<User> readUsers() {
        List<UserEntity> userEntities = userRepository.findAll();
        return userEntities.stream().map(UserEntity::toUser).collect(Collectors.toList());
    }

    @Override
    public User create(User user) {
        return null;
    }

    @Override
    public User read(UUID uuid) {
        return null;
    }

    @Override
    public User update(UUID uuid, User entity) {
        return null;
    }

    @Override
    public void delete(UUID uuid) {

    }
}
