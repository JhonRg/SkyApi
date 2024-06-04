package skyapi.hexagonal.persistence.jpa.adapters;

import skyapi.hexagonal.domain.model.User;
import skyapi.hexagonal.domain.ports.UserPersistencePort;
import skyapi.hexagonal.persistence.jpa.entities.UserEntity;
import skyapi.hexagonal.persistence.jpa.repositories.UserRepository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
}
