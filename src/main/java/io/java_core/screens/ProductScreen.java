package io.java_core.screens;

import io.java_core.models.Product;
import io.java_core.services.CartService;
import io.java_core.services.InventoryService;
import io.java_core.services.ProductService;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ProductScreen implements IScreen {
    private Scanner scanner;
    private ProductService productService;
    private CartService cartService;
    private InventoryService inventoryService;
    private IScreen userHomeScreen;
    private IScreen cartScreen;


    public ProductScreen(ProductService productService, CartService cartService, InventoryService inventoryService) {
        scanner = new Scanner(System.in);
        this.productService = productService;
        this.cartService = cartService;
        this.inventoryService = inventoryService;
    }

    public void setCartScreen(IScreen cartScreen) {
        this.cartScreen = cartScreen;
    }

    public void setUserHomeScreen(IScreen userHomeScreen) {
        this.userHomeScreen = userHomeScreen;
    }

    @Override
    public IScreen display() {

//        Display productList
        List<Product> productList = productService.getAllProducts();

        List<Product> productList1 = productList.stream()
                .filter(inventoryService::inStock)
                .collect(Collectors.toList());

        productList1.stream().forEach(System.out::println);

        System.out.println();
        System.out.println();

        banner();
        int choice = retrieveChoice();
        return performTask(choice);
    }

    private void banner() {
        System.out.println();
        System.out.println();
        System.out.println("=====================================");
        System.out.println("            Product Screen           ");
        System.out.println("=====================================");
        System.out.println();
    }

    private int retrieveChoice() {
        System.out.println("1. Add Products to the Cart");
        System.out.println("2. Go to the Cart");
        System.out.println("3. Go to Homepage");
        System.out.println();
        System.out.print("Enter the choice: ");
        int choice = scanner.nextInt();

        return choice;
    }

    private IScreen performTask(int choice) {

        IScreen screen = switch (choice) {
            case 1 -> {
                System.out.print("Enter the product id: ");
                long id = scanner.nextLong();
                Optional<Product> p = productService.findProduct(id);
                cartService.addProductToCart(p.get());
                inventoryService.decrementStock(p.get());
                System.out.println("Added to the cart...");
                yield this;
            }

            case 2 -> cartScreen;
            case 3 -> userHomeScreen;
            default -> {
                System.out.println("Please choose the correct option. Please Enter to continue");
                scanner.nextLine();
                yield  this;
            }
        };

        return screen;
    }
}
