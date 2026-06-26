package io.java_core.screens;

import io.java_core.models.GlobalContext;
import io.java_core.models.Role;
import io.java_core.models.User;
import io.java_core.services.*;

import java.util.Optional;
import java.util.Scanner;

public class LoginRegisterScreen implements IScreen {

    private Scanner scanner;
    private UserService userService;
    private AuthorizationService authorizationService;

    private IScreen adminHomeScreen;
    private IScreen userHomeScreen;

    public LoginRegisterScreen(UserService userService, AuthorizationService authorizationService) {
        scanner = new Scanner(System.in);
        this.userService = userService;
        this.authorizationService = authorizationService;
    }

    public void setAdminHomeScreen(IScreen adminHomeScreen) {
        this.adminHomeScreen = adminHomeScreen;
    }

    public void setUserHomeScreen(IScreen userHomeScreen) {
        this.userHomeScreen = userHomeScreen;
    }

    @Override
    public IScreen display() {

//        Banner

        System.out.println();
        System.out.println();
        System.out.println("========================================");
        System.out.println("         Register/Login Screen          ");
        System.out.println("========================================");
        System.out.println();


//        Options

        System.out.println("1. Register as New User");
        System.out.println("2. Login");
        System.out.println();

        System.out.print("Enter your Choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        switch(choice) {
            case 1:
                registerUser();
                return this;
            case 2:
                boolean isLoggedIn = loginUser();
                if(!isLoggedIn) {
                    System.out.println("User does not login...");
                    return this;
                }

                GlobalContext context = GlobalContext.getInstance();
                Optional<User> u = context.get("user");

                if(u.isEmpty()) {
                    System.out.println("Oh Snap!! Something went wrong... Try again...");
                    System.out.println();
                    System.out.println();
                    System.out.println();
                    System.out.println("Press enter to continue...");
                    scanner.nextLine();
                    return this;
                }

                if(u.get().getRole() == Role.ADMIN) {
                    return adminHomeScreen;
                } else return userHomeScreen;


            default:
                System.err.print("Please select a correct option. Please Enter to continue.");
                scanner.nextLine();
                return this;
        }
    }

    private void registerUser() {

        System.out.println();
        System.out.println();

//        Accumulating Information...
        System.out.println("Please provide the following information:");
        System.out.println();

//        Name
        System.out.print("Name: ");
        String name = scanner.nextLine().strip();   // Reads the name

//        Email
        System.out.print("Email: ");
        String email = scanner.nextLine().strip();

//        Password
        System.out.print("Password: ");
        String password = scanner.nextLine().strip();

//        Address
        System.out.print("Address: ");
        String address = scanner.nextLine().strip();

        // validate the inputs - Skipping it...
        User u = new User(name, email, password, address);

        try {
            boolean isRegistered = authorizationService.singUp(u);
            System.out.println();
            System.out.println();
            if(isRegistered) System.out.println("!!! Registered Successfully !!!");
            System.out.println("Press Enter to Login...");
            scanner.nextLine();
//            return true;
        } catch (UserAlreadyExistsException e) {
            System.out.println();
            System.out.println();
            u.setPassword("****");
            System.out.println("Oh Snap!! User " + u.toString() + " already exists...");
            System.out.println("Press Enter to try again...");
            scanner.nextLine();
//            return false;
        }
    }

    private boolean loginUser() {

        System.out.println();
        System.out.println();

//        Email
        System.out.print("Email: ");
        String email = scanner.nextLine().strip();

//        Password
        System.out.print("Password: ");
        String password = scanner.nextLine().strip();

        try {
            return authorizationService.login(email, password);
        } catch (UserNotFoundException e) {
            System.out.println("oh Snap!! User not found... Try again...");
            System.out.println("Press Enter to continue...");
            scanner.nextLine();
            return false;
        } catch (InvalidCredentialsException e) {
            System.out.println("oh Snap!! Invalid Credentials... Try again...");
            System.out.println("Press Enter to continue...");
            scanner.nextLine();
            return false;
        }
    }
}