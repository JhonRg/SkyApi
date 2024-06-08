package skyapi.hexagonal.domain.ports.out;


import skyapi.hexagonal.domain.model.User;

import java.util.List;
import java.util.UUID;

public interface UserPersistencePort extends GenericPersistencePort<User, UUID> {
    User createUser(User user);
    List<User> readUsers();
}
