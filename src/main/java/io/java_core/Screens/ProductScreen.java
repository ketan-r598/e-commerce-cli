package io.java_core.Screens;

import io.java_core.models.Product;
import io.java_core.services.CartService;
import io.java_core.services.ProductService;

import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class ProductScreen implements IScreen {
    private Scanner scanner;
    private ProductService productService;
    private CartService cartService;
    private IScreen homeScreen;

    public ProductScreen(ProductService productService, CartService cartService) {
        scanner = new Scanner(System.in);
        this.productService = productService;
        this.cartService = cartService;
        homeScreen = null;
    }

    public void setHomeScreen(IScreen homeScreen) {
        this.homeScreen = homeScreen;
    }

    @Override
    public IScreen display() {

        System.out.println();
        System.out.println();
        System.out.println("=====================================");
        System.out.println("            Product Screen           ");
        System.out.println("=====================================");
        System.out.println();

        AtomicInteger i = new AtomicInteger();
        List<Product> productList = productService.getAllProducts();
        productList.forEach((p) -> System.out.println(i.getAndIncrement() + " " + p));

        System.out.println();
        System.out.println();

        System.out.println("1. Add Products to the Cart");
        System.out.println("2. Go to homepage");
        System.out.println();
        System.out.print("Enter the choice: ");
        int choice = scanner.nextInt();
        int index = -1;
        switch(choice) {
            case 1:
                System.out.print("Enter the product index: ");
                index = scanner.nextInt();
                scanner.nextLine();
                cartService.addProductToCart(productList.get(index));
                return this;

            case 2:
                return homeScreen;

            default:
                System.out.println("Please choose the correct option. Please Enter to continue");
                scanner.nextLine();
                return this;
        }
    }
}
