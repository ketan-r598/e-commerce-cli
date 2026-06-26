package io.java_core.services;

import io.java_core.models.Role;
import io.java_core.models.User;
import io.java_core.stores.UserStore;

import java.util.Optional;

public class UserService {

    private UserStore userStore;

    public UserService(UserStore userStore) {
        this.userStore = userStore;

        User adminUser = new User("admin", "admin@gmail.com","admin@123","NA");
        adminUser.setRole(Role.ADMIN);
        userStore.addUser(adminUser);
    }

    public Optional<User> findUser(String email) throws UserNotFoundException, IllegalArgumentException {
        if(email == null || !email.contains("@"))
            throw new IllegalArgumentException("Email id is not valid...");

        return Optional.of(userStore.findByEmailId(email)
                .orElseThrow(() -> new UserNotFoundException("User does not exists...")));
    }

    public User saveUser(User u) throws UserAlreadyExistsException {
        if(userStore.findByEmailId(u.getEmail()).isEmpty()) {
            return userStore.addUser(u);
        } else {
            throw new UserAlreadyExistsException("User Already Exist. Cannot create new user");
        }
    }

    public User updateUser(User u) throws UserNotFoundException{
        if(userStore.findByEmailId(u.getEmail()).isEmpty()) {
            throw new UserNotFoundException("User does not exists...");
        } else {
            return userStore.updateUser(u);
        }
    }

    public boolean deleteUser(User u) throws UserNotFoundException {
        if(userStore.findByEmailId(u.getEmail()).isEmpty()) {
            throw new UserNotFoundException("User does not exists...");
        } else {
            return userStore.deleteUser(u);
        }
    }
}
