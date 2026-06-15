package io.java_core.Screens;

import io.java_core.models.User;
import io.java_core.services.UserNotFoundException;
import io.java_core.services.UserService;

import java.util.Scanner;

public class LoginScreen implements IScreen {

    private Scanner scanner;
    private UserService userService;
    private IScreen homeScreen;

    public LoginScreen(UserService userService) {
        scanner = new Scanner(System.in);
        this.userService = userService;
        homeScreen = null;
    }

    public void setHomeScreen(IScreen homeScreen) {
        this.homeScreen = homeScreen;
    }

    @Override
    public IScreen display() {

        System.out.println();
        System.out.println();
        System.out.println("====================================");
        System.out.println("           Login Screen             ");
        System.out.println("====================================");
        System.out.println();


        System.out.print("Enter your email: ");
        String email = scanner.next();
        scanner.nextLine();


        System.out.print("Enter the password: ");
        String password = scanner.next();
        scanner.nextLine();

        System.out.println();
//        TODO:: validate the inputs

        try {
            User u = userService.findByEmail(email);
            if(!u.getPassword().equals(password)) {
                System.err.println("Wrong Password! Try Again!! Press Enter to continue.");
                scanner.nextLine();
                return this;
            }
        } catch (UserNotFoundException e) {
            System.err.println("Oh Snap! User does not exist. Please try again");
            scanner.nextLine();
            return this;
        }

        return homeScreen;
    }
}
