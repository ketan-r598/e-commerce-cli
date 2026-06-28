package io.java_core;

import io.java_core.screens.*;
import io.java_core.services.AuthenicationService;
import io.java_core.services.UserService;
import io.java_core.stores.UserStore;
import io.java_core.utils.AuthContext;

public class InitialSetup {

    public static IScreen setup() {

        AuthContext.clearContext();

//        Stores/Repositories
        UserStore userStore = new UserStore();

//        Services
        UserService userService = new UserService(userStore);
        AuthenicationService authenicationService = new AuthenicationService(userService);

//        Screens
        LoginRegisterScreen loginRegisterScreen = new LoginRegisterScreen(userService, authenicationService);
//        LoginScreen loginScreen = new LoginScreen(authenicationService);
        HomeScreen homeScreen = new HomeScreen();
        AdminHomeScreen adminHomeScreen = new AdminHomeScreen();
        UserHomeScreen userHomeScreen = new UserHomeScreen();

        loginRegisterScreen.setAdminHomeScreen(adminHomeScreen);
        loginRegisterScreen.setUserHomeScreen(userHomeScreen);

//        loginRegisterScreen.setLoginScreen(loginScreen);
//        loginScreen.setHomeScreen(homeScreen);

        return loginRegisterScreen;
    }
}
