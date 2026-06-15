package io.java_core.Screens;

import java.io.IOException;
import java.util.Scanner;

public class LoginRegisterScreen implements IScreen {

    private Scanner scanner;
    private IScreen loginScreen;

    public LoginRegisterScreen() {
        scanner = new Scanner(System.in);
        loginScreen = null;
    }

    public void setLoginScreen(IScreen loginScreen) {
        this.loginScreen = loginScreen;
    }

    @Override
    public IScreen display() {

        System.out.println();
        System.out.println();
        System.out.println("========================================");
        System.out.println("         Register/Login Screen          ");
        System.out.println("========================================");
        System.out.println();


        System.out.println("1. Register New User (Coming Soon)");
        System.out.println("2. Login");
        System.out.println();

        System.out.print("Enter your Choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        switch(choice) {
            case 1:
                System.out.println();
                System.out.println();
                System.err.println("It will be coming soon. Please Enter to continue. ");
                scanner.nextLine();
                return this;
            case 2:
                return loginScreen;
            default:
                System.err.print("Please select a correct option. Please Enter to continue.");
                scanner.nextLine();
                return this;
        }
    }
}