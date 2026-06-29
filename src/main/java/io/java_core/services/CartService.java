package io.java_core.services;

import io.java_core.models.Cart;
import io.java_core.models.Product;

public class CartService {

    private final Cart cart;

    public CartService() {
        this.cart = new Cart();
    }

    public void addProductToCart(Product product) {
        cart.addProduct(product);
    }


    public void removeProductToCart(Product product) {
        cart.removeProduct(product);
    }

    public void displayCartItems() {
        cart.displayCart();
    }
}
