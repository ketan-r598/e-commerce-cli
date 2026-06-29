package io.java_core.models;

import io.java_core.utils.GsonUtils;

import java.util.Objects;
import java.util.UUID;

public class Product {
    private final Long productId;
    private String name;
    private String type;
    private Double price;

    public Product(String name, String type, Double price) {

        Objects.requireNonNull(name);
        Objects.requireNonNull(type);
        Objects.requireNonNull(price);

        this.productId = UUID.randomUUID().getMostSignificantBits() & Long.MAX_VALUE;
        this.name = name;
        this.type = type;
        this.price = price;
    }

//    Getters
    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public Double getPrice() {
        return price;
    }

    public Long getProductId() {
        return productId;
    }

//    Setters
    public void setType(String type) {
        this.type = type;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Product)) return false;
        Product product = (Product) o;
        return Objects.equals(name, product.productId);
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
