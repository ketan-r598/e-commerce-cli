package io.java_core;

import io.java_core.models.GlobalContext;
import io.java_core.screens.*;
import io.java_core.services.AuthorizationService;
import io.java_core.services.UserService;
import io.java_core.stores.UserStore;

public class InitialSetup {

//    TODO::
    public static IScreen setup() {

        GlobalContext context = GlobalContext.getInstance();
        context.clearContext();

//        Stores/Repositories
        UserStore userStore = new UserStore();

//        Services
        UserService userService = new UserService(userStore);
        AuthorizationService authorizationService = new AuthorizationService(userService, context);

//        Screens
        LoginRegisterScreen loginRegisterScreen = new LoginRegisterScreen(userService, authorizationService);
//        LoginScreen loginScreen = new LoginScreen(authorizationService);
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
