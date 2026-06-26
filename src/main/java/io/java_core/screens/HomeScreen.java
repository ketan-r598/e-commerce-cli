package io.java_core.screens;

import io.java_core.models.Product;
import io.java_core.services.CartService;
import io.java_core.services.ProductService;

import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class HomeScreen implements IScreen {

//    private final Scanner scanner;
//    private IScreen productScreen;
//    private IScreen cartScreen;
//    private IScreen loginRegistrationScreen;
//    private final ProductService productService;
//    private final CartService cartService;

//    public HomeScreen(CartService cartService, ProductService productService) {
//        scanner = new Scanner(System.in);
//        this.productService = productService;
//        this.cartService = cartService;
//        cartScreen = null;
//        loginRegistrationScreen = null;
//    }

//    public void setCartScreen(IScreen cartScreen) {
//        this.cartScreen = cartScreen;
//    }

//    public void setLoginRegistrationScreen(IScreen loginRegistrationScreen) {
//        this.loginRegistrationScreen = loginRegistrationScreen;
//    }

//    public void setProductScreen(IScreen productScreen) {
//        this.productScreen = productScreen;
//    }

    @Override
    public IScreen display() {
        System.out.println();
        System.out.println();
        System.out.println("=====================================");
        System.out.println("            Home Screen              ");
        System.out.println("=====================================");
        System.out.println();


//        System.out.println("1. Add Products to your Cart");
//        System.out.println("2. Check your Cart");
//        System.out.println("3. Logout");
//        System.out.println();
//
//
//        System.out.print("Enter your choice: ");
//        int choice = scanner.nextInt();
//        scanner.nextLine();
//
//
//        AtomicInteger i = new AtomicInteger();
//        List<Product> productList = productService.getAllProducts();
//
//        switch (choice) {
//            case 1:
//              Display the List of products.
//                productList.forEach((p) -> System.out.println(i.getAndIncrement() + " " + p));
//
//              Ask to choose the product
//                System.out.print("Enter the product index: ");
//
//                int index = scanner.nextInt();
//                scanner.nextLine();
//
//                cartService.addToCart(products[i]);
//                return productScreen;
//            case 2:
//                return cartScreen;
//            case 3:
//                return loginRegistrationScreen;
//            default:
//                System.out.println("Please choose the correct option. Press Enter to continue");
//                scanner.nextLine();
//                return this;
//        }
        return null;
    }
}
