package io.java_core.models;

import io.java_core.utils.GsonUtils;

public class CartItem {
    private Product product;
    private Long quantity;

    public CartItem(Product product, Long quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return GsonUtils.serialize(this);
    }
}
