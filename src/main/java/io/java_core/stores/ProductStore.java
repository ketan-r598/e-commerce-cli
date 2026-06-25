package io.java_core.stores;

import io.java_core.models.Product;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ProductStore {

    private HashMap<String, Product> productStoreMap;

    public ProductStore() {
        productStoreMap = new HashMap<>();

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

        productStoreMap.put(p0.getId(), p0);
        productStoreMap.put(p1.getId(), p1);
        productStoreMap.put(p2.getId(), p2);
        productStoreMap.put(p3.getId(), p3);
        productStoreMap.put(p4.getId(), p4);
        productStoreMap.put(p5.getId(), p5);
        productStoreMap.put(p6.getId(), p6);
        productStoreMap.put(p7.getId(), p7);
        productStoreMap.put(p8.getId(), p8);
        productStoreMap.put(p9.getId(), p9);
    }

    public Optional<Product> findById(String id) {
        return Optional.ofNullable(productStoreMap.getOrDefault(id, null));
    }

    public List<Product> getProductList() {
        return productStoreMap.entrySet()
                              .stream()
                              .map(p -> p.getValue())
                              .collect(Collectors.toList());
    }

    public Optional<Product> updateProduct(Product product) {
        productStoreMap.put(product.getId(), product);
        productStoreMap.get(product.getId());

        return Optional.of(productStoreMap.get(product.getId()));
    }

//    TODO::
    public Optional<Product> deleteProduct(Product product) { return Optional.empty();}

}
