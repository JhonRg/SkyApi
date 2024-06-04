package skyapi.hexagonal.domain.ports;


import skyapi.hexagonal.domain.model.User;

import java.util.List;

public interface UserPersistencePort {
    User createUser(User user);
    List<User> readUsers();
}
