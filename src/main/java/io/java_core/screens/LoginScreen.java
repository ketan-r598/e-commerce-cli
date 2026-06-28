package io.java_core.screens;

import io.java_core.models.User;
import io.java_core.services.*;

import java.util.Scanner;

public class LoginScreen implements IScreen {

    private Scanner scanner;
    private AuthenicationService authService;
    private IScreen homeScreen;

    public LoginScreen(AuthenicationService authService) {
        scanner = new Scanner(System.in);
        this.authService = authService;
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
            User isLoggedIn = authService.login(email, password);
            if ((isLoggedIn == null)) {
                System.err.println("Wrong Password! Try Again!! Press Enter to continue.");
                scanner.nextLine();
                return this;
            }
        } catch (UserNotFoundException | InvalidCredentialsException e) {
            System.err.println("Oh Snap! User does not exist. Please try again");
            scanner.nextLine();
            return this;
        }

        return homeScreen;
    }
}
