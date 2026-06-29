package io.java_core.stores;

import io.java_core.models.Product;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ProductStore {

    private HashMap<Long, Product> productStoreMap;

    public ProductStore() {
        productStoreMap = new HashMap<>();
    }

    public Optional<Product> findById(Long id) {
        return Optional.ofNullable(productStoreMap.getOrDefault(id, null));
    }

    public List<Product> getProductList() {
        return productStoreMap.entrySet()
                              .stream()
                              .map(p -> p.getValue())
                              .collect(Collectors.toList());
    }

    public Optional<Product> saveProduct(Product product) {
        return Optional.ofNullable(productStoreMap.putIfAbsent(product.getProductId(), product));
    }

    public Optional<Product> updateProduct(Product product) {
        productStoreMap.put(product.getProductId(), product);
        productStoreMap.get(product.getProductId());

        return Optional.of(productStoreMap.get(product.getProductId()));
    }


    public Optional<Product> deleteProduct(Product product) {
        return Optional.ofNullable(productStoreMap.remove(product.getProductId()));
    }

}
