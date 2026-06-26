package io.java_core.services;

import io.java_core.models.GlobalContext;
import io.java_core.models.User;

import java.util.Optional;

public class AuthorizationService {

    private final UserService userService;
    private GlobalContext globalContext;

    public AuthorizationService(UserService userService, GlobalContext globalContext) {
        this.userService = userService;
        this.globalContext = globalContext;
    }

    public boolean login(String email, String password) throws UserNotFoundException, InvalidCredentialsException {
        Optional<User> user = userService.findUser(email);

        if(user.isEmpty()) throw new UserNotFoundException("User does not exists...");

        if(user.get().getPassword().equalsIgnoreCase(password)) {
            globalContext.add("user",user.get());
            return true;
        } else {
            throw new InvalidCredentialsException("Either email or password is incorrect");
        }
    }

    public boolean singUp(User user) throws UserAlreadyExistsException {
        try {
            Optional<User> u =  userService.findUser(user.getEmail());
            if(u.isEmpty()) {
                userService.saveUser(user);
                return true;
            } else {
                return false;
            }
        } catch (UserNotFoundException e) {
            userService.saveUser(user);
            return true;
        } catch (UserAlreadyExistsException e) {
            throw e;
        }
    }

    public boolean logout() {
        globalContext.clearContext();
        return true;
    }
}
