package io.java_core.services;

import io.java_core.models.User;
import io.java_core.stores.UserStore;

import java.util.Objects;
import java.util.Optional;

public class UserService {

    private UserStore userStore;

    public UserService(UserStore userStore) {
        this.userStore = userStore;
    }

    public Optional<User> findUser(String email) throws IllegalArgumentException {
        if(email == null || !email.contains("@"))
            throw new IllegalArgumentException("Email id is not valid...");

        return userStore.findByEmailId(email);
    }

    public Optional<User> saveUser(User u) {
        Objects.requireNonNull(u);

        if(userStore.findByEmailId(u.getEmail()).isEmpty()) {
            return Optional.of(userStore.addUser(u));
        }
        return Optional.empty();
    }

    public User updateUser(User u) throws UserNotFoundException {
        Objects.requireNonNull(u);

        if(userStore.findByEmailId(u.getEmail()).isEmpty()) {
            throw new UserNotFoundException("User does not exists...");
        } else {
            return userStore.updateUser(u);
        }
    }

    public User deleteUser(User u) throws UserNotFoundException {
        Objects.requireNonNull(u);

        if(userStore.findByEmailId(u.getEmail()).isEmpty()) {
            throw new UserNotFoundException("User does not exists...");
        } else {
            return userStore.deleteUser(u);
        }
    }
}
