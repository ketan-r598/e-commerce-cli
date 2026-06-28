package io.java_core.services;

import io.java_core.models.User;
import io.java_core.utils.AuthContext;

import java.util.Objects;
import java.util.Optional;

public class AuthenicationService {

    private final UserService userService;

    public AuthenicationService(UserService userService) {
        this.userService = userService;
    }

    public User login(String email, String password) throws UserNotFoundException, InvalidCredentialsException {
        Objects.requireNonNull(email);
        Objects.requireNonNull(password);

        if(email.isBlank() || password.isBlank())
            throw new InvalidCredentialsException("Either Email or Password is incorrect...");

        Optional<User> user = userService.findUser(email);
        if(user.isEmpty()) throw new UserNotFoundException("User does not exists...");

        if(user.get().getPassword().equalsIgnoreCase(password)) {
            return user.get();
        } else {
            throw new InvalidCredentialsException("Either email or password is incorrect");
        }
    }

    public void singUp(User user) throws UserAlreadyExistsException {

        Objects.requireNonNull(user);

        Optional<User> registeredUser = userService.saveUser(user);
        if(registeredUser.isEmpty()) throw new UserAlreadyExistsException("User Already Exists...");
    }

    public boolean logout() {
        AuthContext.clearContext();
        return true;
    }
}
