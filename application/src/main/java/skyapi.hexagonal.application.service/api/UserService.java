package skyapi.hexagonal.application.service.api;


import skyapi.hexagonal.domain.model.User;

import java.util.List;

public interface UserService {
    User createUser(User user);
    List<User> readUsers();
}
