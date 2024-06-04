package skyapi.hexagonal.application.service.adapter;

import com.Sky.SkyApi.domain.ports.UserPersistencePort;
import org.springframework.beans.factory.annotation.Autowired;
import skyapi.hexagonal.application.service.api.UserService;
import skyapi.hexagonal.domain.model.User;

import java.util.List;

public class UserServiceAdapter implements UserService {

    private UserPersistencePort userPersistencePort;

    @Autowired
    public UserServiceAdapter(UserPersistencePort userPersistencePort) {
        this.userPersistencePort = userPersistencePort;
    }

    @Override
    public User createUser(User user) {
        return userPersistencePort.createUser(user);
    }

    @Override
    public List<User> readUsers() {
        return userPersistencePort.readUsers();
    }
}
