package skyapi.hexagonal.persistence.jpa.adapters;

import com.Sky.SkyApi.domain.ports.UserPersistencePort;
import skyapi.hexagonal.domain.model.User;
import skyapi.hexagonal.persistence.jpa.entities.UserEntity;
import skyapi.hexagonal.persistence.jpa.repositories.UserRepository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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
        List<User> users = new ArrayList<>();
        userEntities.forEach(userEntity -> {users.add(userEntity.toUser());});
        return users;
    }
}
