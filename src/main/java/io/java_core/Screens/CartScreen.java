package io.java_core.Screens;

import io.java_core.services.CartService;
import io.java_core.services.OrderService;

import java.util.Scanner;

public class CartScreen implements IScreen {

    private Scanner scanner;
    private CartService cartService;
    private OrderService orderService;
    private IScreen homePage;

    public CartScreen(CartService cartService, OrderService orderService) {
        scanner = new Scanner(System.in);
        this.cartService = cartService;
        this.orderService = orderService;
        homePage = null;
    }

    public void setHomePage(IScreen homePage) {
        this.homePage = homePage;
    }

    @Override
    public IScreen display() {

        System.out.println();
        System.out.println();
        System.out.println("=====================================");
        System.out.println("            Cart Screen              ");
        System.out.println("=====================================");
        System.out.println();

        System.out.println("1. Display items in your Cart");
        System.out.println("2. Remove Items from the Cart (coming soon");
        System.out.println("3. Checkout the Cart (coming soon)");
        System.out.println("4. Go Back to Home Page");
        System.out.println();

        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
//              Get the list of products.
                cartService.getProductsList().keySet().forEach(System.out::println);
                return this;
            case 2:
//                Get the listing of items
//                System.out.println("Enter the index of product to be removed");
//                choice = scanner.nextInt();
//                remove the items from the cart
                System.out.println("Coming soon. Press Enter to Continue");
                scanner.nextLine();
                return this;
            case 3:
//                Add cart to order and set the current cart to null;
//                orderService.addOrder(cartService.getCart());
//                cartService.setCart(null);
                System.out.println("Coming soon. Press Enter to Continue");
                scanner.nextLine();
                return this;
            case 4:
                return homePage;
            default:
                System.out.println("Please choose the correct option. Please Enter the correct option.");
                scanner.nextLine();
                return this;
        }

//        return null;
    }
}
