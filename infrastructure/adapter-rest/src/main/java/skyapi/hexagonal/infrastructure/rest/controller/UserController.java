package skyapi.hexagonal.infrastructure.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController{

    private final UserServiceAdapter userServiceAdapter;
    @Autowired

    public UserController(UserServiceAdapter userServiceAdapter) {
        this.userServiceAdapter = userServiceAdapter;
    }

    public List<User> getUsers() {
        return null;
    }

    public User createUser(User user) {
        return null;
    }
}
