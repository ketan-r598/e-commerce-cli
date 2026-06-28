package io.java_core.screens;

import io.java_core.models.Role;
import io.java_core.models.User;
import io.java_core.services.*;
import io.java_core.utils.AuthContext;

import java.util.Optional;
import java.util.Scanner;

public class LoginRegisterScreen implements IScreen {

    private Scanner scanner;
    private UserService userService;
    private AuthenicationService authenicationService;

    private IScreen adminHomeScreen;
    private IScreen userHomeScreen;

    @Override
    public IScreen display() {

        banner();
        int choice = retrieveChoice();
        return performTask(choice);
    }


    private void banner() {

        System.out.println();
        System.out.println();
        System.out.println("========================================");
        System.out.println("         Register/Login Screen          ");
        System.out.println("========================================");
        System.out.println();
    }

    private int retrieveChoice() {

        System.out.println("1. Register as New User");
        System.out.println("2. Login");
        System.out.println();

        System.out.print("Enter your Choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        return choice;
    }

    private IScreen performTask(int choice) {
        switch(choice) {
            case 1:
                registerUser();
                return this;
            case 2:
                Optional<User> loggedUser = Optional.ofNullable(loginUser());

                if(loggedUser.isEmpty()) {
                    System.err.println("Oh Snap!! Something went wrong... Try again...");
                    System.out.println();
                    System.out.println();
                    System.out.println("Press enter to continue...");
                    scanner.nextLine();
                    return this;
                }

//                Adding to the context
                AuthContext.addItem("user", loggedUser.get());

                if(loggedUser.get().getRole() == Role.ADMIN) {
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

        // validate the inputs - Skipping it for now...
        User u = new User(name, email, password, address);

        try {
            authenicationService.singUp(u);
            System.out.println();
            System.out.println("!!! Registered Successfully !!!");
            System.out.print("Press Enter to Login...");
            scanner.nextLine();
        } catch (UserAlreadyExistsException e) {
            System.out.println();
            System.out.println();
            System.err.println("Oh Snap!! User " + u.toString() + " already exists...");
            System.out.println("Press Enter to try again...");
            scanner.nextLine();
        }
    }

    private User loginUser() {

        System.out.println();
        System.out.println("======================================");
        System.out.println("                Login                 ");
        System.out.println("======================================");
        System.out.println();

//        Email
        System.out.print("Email: ");
        String email = scanner.nextLine().strip();

//        Password
        System.out.print("Password: ");
        String password = scanner.nextLine().strip();

        try {
            return authenicationService.login(email, password);
        } catch (UserNotFoundException e) {
            System.err.println("oh Snap!! User not found... Try again...");
            System.out.println("Press Enter to continue...");
            scanner.nextLine();
            return null;
        } catch (InvalidCredentialsException e) {
            System.err.println("oh Snap!! Invalid Credentials... Try again...");
            System.out.println("Press Enter to continue...");
            scanner.nextLine();
            return null;
        }
    }


//    Setters
    public LoginRegisterScreen(UserService userService, AuthenicationService authenicationService) {
        scanner = new Scanner(System.in);
        this.userService = userService;
        this.authenicationService = authenicationService;
    }

    public void setAdminHomeScreen(IScreen adminHomeScreen) {
        this.adminHomeScreen = adminHomeScreen;
    }

    public void setUserHomeScreen(IScreen userHomeScreen) {
        this.userHomeScreen = userHomeScreen;
    }
}