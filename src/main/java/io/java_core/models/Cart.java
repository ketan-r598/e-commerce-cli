package io.java_core.models;

import java.util.*;
import java.util.stream.Collectors;

public class Cart {
    private final String cartId;
//    private final Long userId;
    private HashMap<Product, Long> productList;

    public Cart() {
        this.cartId = UUID.randomUUID().toString();
//        this.userId = userId;
        this.productList = new HashMap<>();
    }

    public String getCartId() {
        return cartId;
    }

    public HashMap<Product, Long> getProductList() {
        return new HashMap<>(productList);
    }

//    public Long getUserId() {
//        return userId;
//    }

    public Cart addProductToCart(Product product) {
        productList.merge(product, 1L, Long::sum);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Cart)) return false;
        Cart cart = (Cart) o;
        return Objects.equals(cartId, cart.cartId) && Objects.equals(productList, cart.productList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cartId, productList);
    }

    @Override
    public String toString() {
        return "Cart{" +
                "cartId=" + cartId +
                ", productList=" + productList.toString() +
                '}';
    }
}
