package io.java_core.models;

import io.java_core.utils.GsonUtils;

import java.util.Objects;

public class InventoryItem {
    private final Long productId;
    private Long quantity;

    public InventoryItem(Long productId) {
        this(productId,0L);
    }
    public InventoryItem(Long productId, Long quantity) {
        this.productId = productId;
        this.quantity = quantity;
    }

//    Getters

    public Long getProductId() {
        return productId;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }
//    equals and hashcodes

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof InventoryItem)) return false;
        InventoryItem that = (InventoryItem) o;
        return Objects.equals(productId, that.productId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId);
    }

    @Override
    public String toString() {
        return GsonUtils.serialize(this);
    }
}
