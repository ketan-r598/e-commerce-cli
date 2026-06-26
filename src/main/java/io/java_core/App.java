package io.java_core;

import io.java_core.screens.*;
import io.java_core.models.Role;
import io.java_core.models.User;
import io.java_core.services.*;
import io.java_core.stores.ProductStore;
import io.java_core.stores.UserStore;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ) {

//        Doing initial setup
        IScreen screen = InitialSetup.setup();

        System.out.println("========================================");
        System.out.println("        Welcome to E-Comm CLI App       ");
        System.out.println("========================================");

        while(screen != null) {
            screen = screen.display();
        }


//      Initial Setup
//        User user = new User(
//                "Ketan R","ketan_r@gmail.com",
//                "ketan@123", Role.USER);


//      Stores
//        UserStore userStore = new UserStore();
//        ProductStore productStore = new ProductStore();


//      Services
//        CartService cartService = new CartService();
//        ProductService productService = new ProductService(productStore);
//        UserService userService = new UserService(userStore);
//        OrderService orderService = new OrderService();


//        try {
//            userService.saveUser(user);
//        } catch (UserAlreadyExist e) {
//            System.out.println(e.getMessage());
//        }



//      Screens
//        LoginRegisterScreen loginRegisterScreen = new LoginRegisterScreen();
//        LoginScreen loginScreen = new LoginScreen(userService);
//        HomeScreen homeScreen = new HomeScreen(cartService, productService);
//        ProductScreen productScreen = new ProductScreen(productService, cartService);
//        CartScreen cartScreen = new CartScreen(cartService, orderService);
//        OrderScreen orderScreen = new OrderScreen(orderService);

//      Passing the required screens into each of the screens
//        loginRegisterScreen.setLoginScreen(loginScreen);
//        loginScreen.setHomeScreen(homeScreen);
//        homeScreen.setLoginRegistrationScreen(loginRegisterScreen);
//        homeScreen.setCartScreen(cartScreen);
//        homeScreen.setProductScreen(productScreen);
//        productScreen.setHomeScreen(homeScreen);
//        cartScreen.setHomePage(homeScreen);


//        IScreen screen = loginRegisterScreen;

//        while(screen != null) {
//            screen = screen.display();
//        }
    }
}
