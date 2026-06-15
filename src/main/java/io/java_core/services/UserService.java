package io.java_core.services;

import io.java_core.models.User;
import io.java_core.stores.UserStore;

import java.util.Optional;

public class UserService {

    private UserStore userStore;

    public UserService(UserStore userStore) {
        this.userStore = userStore;
    }

    public User findByEmail(String email) throws UserNotFoundException {
        return userStore.findByEmail(email)
                        .orElseThrow(() -> new UserNotFoundException("User does not exist"));
    }

    public User saveUser(User user) throws UserAlreadyExist {
        return userStore.saveUser(user)
                .orElseThrow(() -> new UserAlreadyExist("User Already exists"));
    }

//    TODO::
    public User updateUser(User user) {
        return null;
    }

//    TODO::
    public User deleteUser(User user) {
        return null;
    }


}
