package skyapi.hexagonal.infrastructure.rest.controller;

import skyapi.hexagonal.domain.model.User;

import java.util.List;

public interface UserController {
    public List<User> getUsers();
    public User createUser(User user);
}
