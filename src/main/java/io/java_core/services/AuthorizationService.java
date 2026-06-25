package io.java_core.services;

import io.java_core.models.GlobalContext;
import io.java_core.models.User;

public class AuthorizationService {

    private final UserService userService;
    private GlobalContext globalContext;

    public AuthorizationService(UserService userService, GlobalContext globalContext) {
        this.userService = userService;
        this.globalContext = globalContext;
    }

//    TODO::
    public boolean login(String email, String password) throws InvalidCredentialsException { return false;}

//    TODO::
    public boolean singUp(User user) throws UserAlreadyExistsException{ return false;}

//    TODO::
    public boolean logout() { return false;}

}
