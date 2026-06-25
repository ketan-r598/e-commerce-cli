package io.java_core.services;

import io.java_core.models.User;
import io.java_core.stores.UserStore;

import java.util.Optional;

public class UserService {

    private UserStore userStore;

    public UserService(UserStore userStore) {
        this.userStore = userStore;
    }

//    TODO::
    public Optional<User> findUser(String email) throws UserNotFoundException {
        return Optional.empty();
    }

//    TODO::
    public User saveUser(User u) throws UserAlreadyExistsException {
        return null;
    }

//    TODO::
    public User updateUser(User u) {return null;}

//    TODO::
    public User deleteUser(User u) {return null;}
}
