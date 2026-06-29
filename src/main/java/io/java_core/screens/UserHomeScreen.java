package io.java_core.screens;

import io.java_core.models.Product;

import java.util.Scanner;

public class UserHomeScreen implements IScreen {

    private final Scanner scanner;

    private ProductScreen productScreen;
    private LoginRegisterScreen loginRegisterScreen;

    public UserHomeScreen() {
        this.scanner = new Scanner(System.in);
    }

    public void setLoginRegisterScreen(LoginRegisterScreen loginRegisterScreen) {
        this.loginRegisterScreen = loginRegisterScreen;
    }

    public void setProductScreen(ProductScreen productScreen) {
        this.productScreen = productScreen;
    }

    @Override
    public IScreen display() {
        banner();
        int choice = retrieveChoice();
        IScreen screen = performTask(choice);
        return screen;
    }

    private void banner() {
        System.out.println();
        System.out.println();
        System.out.println("========================================");
        System.out.println("              User Home Screen          ");
        System.out.println("========================================");
        System.out.println();
    }

    private int retrieveChoice() {
        System.out.println("1. Browse the list of products");
        System.out.println("2. Logout");
        System.out.println();

        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();

        return choice;
    }

    private IScreen performTask(int choice) {

        IScreen screen = switch (choice) {
            case 1  -> productScreen;
            case 2  -> loginRegisterScreen;
            default -> {
                System.out.print("Wrong Choice... Press Enter to try again...");
                scanner.nextLine();
                yield this;
            }
        };

//        System.out.println(screen.getClass().getName());
        return screen;
    }
}
