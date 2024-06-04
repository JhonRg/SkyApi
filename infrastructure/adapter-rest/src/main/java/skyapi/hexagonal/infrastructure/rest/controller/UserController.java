package skyapi.hexagonal.infrastructure.rest.controller;

import skyapi.hexagonal.domain.model.User;

import java.util.List;

public interface UserController {
    List<User> getUsers();
    User createUser(User user);
}
