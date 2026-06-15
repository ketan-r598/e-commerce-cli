package io.java_core.services;

import io.java_core.models.Cart;
import io.java_core.models.Product;

import java.util.HashMap;

public class CartService {

    private final Cart cart;

    public CartService() {
        cart = new Cart();
    }

    public void addProductToCart(Product product) {
        cart.addProductToCart(product);
    }

    // TODO::
    public void removeProductToCart(Product product) {

    }

    public HashMap<Product, Long> getProductsList() {
        return cart.getProductList();
    }
}
