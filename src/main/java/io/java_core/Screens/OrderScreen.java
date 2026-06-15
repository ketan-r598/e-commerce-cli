package io.java_core.Screens;

import io.java_core.services.OrderService;

import java.util.Scanner;

public class OrderScreen implements IScreen {

    private Scanner scanner;
    private String message;
    private OrderService orderService;
    private IScreen homeScreen;

    public OrderScreen(OrderService orderService) {
        message = null;
        this.orderService = orderService;
        this.homeScreen = null;
        scanner = new Scanner(System.in);
    }

    public void setHomeScreen(IScreen homeScreen) {
        this.homeScreen = homeScreen;
    }

    @Override
    public IScreen display() {

        System.out.println("1. Check the latest order and its status");
        System.out.println("2. Check all the orders");
        System.out.println("3. Go back to HomePage");

        if(message != null) System.out.println(message);
        message = null;

        int choice = scanner.nextInt();

        switch(choice) {
            case 1:
//                System.out.println(orderService.getLatestOrder());
                break;
            case 2:
//                System.out.println(orderService.getAllOrders());
                break;
            case 3:
                return homeScreen;
            default:
                message = "Choose the correct option.";
                return this;

        }

        return null;
    }
}
