package skyapi.hexagonal.infrastructure.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import skyapi.hexagonal.application.service.adapter.UserServiceAdapter;
import skyapi.hexagonal.domain.model.User;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserControllerImpl implements UserController {

    private final UserServiceAdapter userServiceAdapter;
    @Autowired
    public UserControllerImpl(UserServiceAdapter userServiceAdapter) {
        this.userServiceAdapter = userServiceAdapter;
    }
    @Override
    public List<User> getUsers() {
        return userServiceAdapter.readUsers();
    }

    @Override
    public User createUser(User user) {
        return userServiceAdapter.createUser(user);
    }
}
