package skyapi.hexagonal.application.service.api;


import skyapi.hexagonal.domain.model.User;

import java.util.List;

public interface UserService {
    public User createUser(User user);
    public List<User> readUsers();
}
