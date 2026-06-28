package io.java_core;

import io.java_core.screens.IScreen;

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
    }
}
