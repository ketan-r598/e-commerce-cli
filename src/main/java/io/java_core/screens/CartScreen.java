package io.java_core.screens;

import io.java_core.services.CartService;
import io.java_core.services.OrderService;
import io.java_core.services.ProductService;

import java.util.Scanner;

public class CartScreen implements IScreen {

    private Scanner scanner;
    private CartService cartService;
    private OrderService orderService;
    private ProductService productService;
    private IScreen userHomePage;

    public CartScreen(CartService cartService, OrderService orderService, ProductService productService) {
        scanner = new Scanner(System.in);
        this.cartService = cartService;
        this.orderService = orderService;
        this.productService = productService;
    }

    public void setHomePage(IScreen userHomePage) {
        this.userHomePage = userHomePage;
    }

    @Override
    public IScreen display() {
        banner();
        int choice = retrieveChoice();
        return performTask(choice);
    }

    private void banner() {
        System.out.println();
        System.out.println();
        System.out.println("=====================================");
        System.out.println("            Cart Screen              ");
        System.out.println("=====================================");
        System.out.println();
    }

    private int retrieveChoice() {
        System.out.println("1. Display items in your Cart");
        System.out.println("2. Remove Items from the Cart");
        System.out.println("3. Checkout the Cart (coming soon)");
        System.out.println("4. Go Back to Home Page");
        System.out.println();

        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();

        return choice;
    }

    private IScreen performTask(int choice) {
        return switch (choice) {
            case 1 -> {
//              Get the list of products.
                cartService.displayCartItems();
                System.out.println();
                System.out.print("Press Enter to continue");
                scanner.nextLine();
                yield this;
            }
            case 2 -> {
//                Get the listing of items
                System.out.print("Enter the product id: ");
                Long index = scanner.nextLong();
                cartService.removeProductToCart(productService.findProduct(index).get());
                System.out.println("Item removed...");
                scanner.nextLine();
                yield this;
            }
            case 3 -> {
//                Add cart to order and set the current cart to null;
//                orderService.addOrder(cartService.getCart());
//                cartService.setCart(null);
                System.out.println("Coming soon. Press Enter to Continue");
                scanner.nextLine();
                yield this;
            }
            case 4 -> userHomePage;
            default -> {
                System.out.println("Please choose the correct option. Please Enter the correct option.");
                scanner.nextLine();
                yield  this;
            }
        };
    }
}
