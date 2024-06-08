package skyapi.hexagonal.out.persistence.adapter;

import skyapi.hexagonal.out.persistence.api.UserService;

public class UserServiceAdapter implements UserService {

    private final UserService userSpringJpaAdapater;

    public UserServiceAdapter(UserService userSpringJpaAdapater) {
        this.userSpringJpaAdapater = userSpringJpaAdapater;
    }


}
