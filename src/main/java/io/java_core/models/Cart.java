package io.java_core.models;

import java.util.*;
import java.util.stream.Collectors;

public class Cart {
    private final Long cartId;
//    private final Long userId;
    private HashMap<Product,CartItem> cartItemList;

    public Cart() {
        this.cartId = UUID.randomUUID().getMostSignificantBits() & Long.MAX_VALUE;
//        this.userId = userId;
        this.cartItemList = new HashMap<>();
    }

//    Getters
    public Long getCartId() {
        return cartId;
    }

    public List<CartItem> getCartItemList() {
        return cartItemList.values().stream().collect(Collectors.toList());
    }

//    public Long getUserId() {
//        return userId;
//    }

    public void addProduct(Product product) {
        if(cartItemList.containsKey(product)) {
            CartItem item = cartItemList.get(product);
            item.setQuantity(item.getQuantity()+1);
            cartItemList.put(product,item);
        } else {
            cartItemList.put(product,new CartItem(product,1L));
        }
    }

    public void removeProduct(Product product) {
        if(cartItemList.containsKey(product)) {
            CartItem item = cartItemList.get(product);
            if(item.getQuantity() - 1 > 0) {
                item.setQuantity(item.getQuantity() - 1);
                cartItemList.put(product, item);
            } else {
                cartItemList.remove(product);
            }
        }
    }

    public void displayCart() {
        cartItemList.values().stream()
                .map(cartItem -> cartItem.toString())
                .forEach(System.out::println);
    }
}
