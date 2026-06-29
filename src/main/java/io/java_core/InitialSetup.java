package io.java_core;

import io.java_core.models.InventoryItem;
import io.java_core.models.Product;
import io.java_core.screens.*;
import io.java_core.services.*;
import io.java_core.stores.InventoryStore;
import io.java_core.stores.ProductStore;
import io.java_core.stores.UserStore;
import io.java_core.utils.AuthContext;

public class InitialSetup {

    public static IScreen setup() {

        AuthContext.clearContext();

//        Stores/Repositories
        UserStore userStore = new UserStore();
        ProductStore productStore = new ProductStore();
        InventoryStore inventoryStore = new InventoryStore();

//        Services
        UserService userService = new UserService(userStore);
        AuthenicationService authenicationService = new AuthenicationService(userService);
        ProductService productService = new ProductService(productStore);
        InventoryService inventoryService = new InventoryService(inventoryStore);
        CartService cartService = new CartService();

        //        Screens
        LoginRegisterScreen loginRegisterScreen = new LoginRegisterScreen(userService, authenicationService);
        AdminHomeScreen adminHomeScreen = new AdminHomeScreen();
        UserHomeScreen userHomeScreen = new UserHomeScreen();
        ProductScreen productScreen = new ProductScreen(productService, cartService,inventoryService);
        CartScreen cartScreen = new CartScreen(cartService, null, productService);

        loginRegisterScreen.setAdminHomeScreen(adminHomeScreen);
        loginRegisterScreen.setUserHomeScreen(userHomeScreen);
        userHomeScreen.setLoginRegisterScreen(loginRegisterScreen);
        userHomeScreen.setProductScreen(productScreen);
        productScreen.setUserHomeScreen(userHomeScreen);
        productScreen.setCartScreen(cartScreen);

//        Add the products...
        Product p0 = new Product("Laptop","Electronics",65000.0);
        Product p1 = new Product("Smartphone", "Electronics", 35000.0);
        Product p2 = new Product("Wireless Mouse", "Accessories", 899.0);
        Product p3 = new Product("Mechanical Keyboard", "Accessories", 2499.0);
        Product p4 = new Product("Office Chair", "Furniture", 7999.0);
        Product p5 = new Product("Study Table", "Furniture", 5999.0);
        Product p6 = new Product("Water Bottle", "Home", 299.0);
        Product p7 = new Product("Coffee Mug", "Home", 199.0);
        Product p8 = new Product("Running Shoes", "Sports", 3499.0);
        Product p9 = new Product("Yoga Mat", "Sports", 1499.0);

        productService.saveProduct(p0);
        productService.saveProduct(p1);
        productService.saveProduct(p2);
        productService.saveProduct(p3);
        productService.saveProduct(p4);
        productService.saveProduct(p5);
        productService.saveProduct(p6);
        productService.saveProduct(p7);
        productService.saveProduct(p8);
        productService.saveProduct(p9);


//        Update the inventory...

        InventoryItem item00 = new InventoryItem(p0.getProductId(),20L);
        InventoryItem item01 = new InventoryItem(p1.getProductId(),30L);
        InventoryItem item02 = new InventoryItem(p2.getProductId(),10L);
        InventoryItem item03 = new InventoryItem(p3.getProductId(),40L);
        InventoryItem item04 = new InventoryItem(p4.getProductId(),50L);
        InventoryItem item05 = new InventoryItem(p5.getProductId(),5L);
        InventoryItem item06 = new InventoryItem(p6.getProductId(),25L);
        InventoryItem item07 = new InventoryItem(p7.getProductId(),21L);
        InventoryItem item08 = new InventoryItem(p8.getProductId(),15L);
        InventoryItem item09 = new InventoryItem(p9.getProductId(),18L);

        inventoryService.addToStock(item00);
        inventoryService.addToStock(item01);
        inventoryService.addToStock(item02);
        inventoryService.addToStock(item03);
        inventoryService.addToStock(item04);
        inventoryService.addToStock(item05);
        inventoryService.addToStock(item06);
        inventoryService.addToStock(item07);
        inventoryService.addToStock(item08);
        inventoryService.addToStock(item09);



        return loginRegisterScreen;
    }
}
