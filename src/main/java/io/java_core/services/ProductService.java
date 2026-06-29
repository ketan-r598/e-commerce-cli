package io.java_core.services;

import io.java_core.models.Product;
import io.java_core.stores.ProductStore;

import java.util.List;
import java.util.Optional;

public class ProductService {

    private ProductStore productStore;

    public ProductService(ProductStore productStore) {
        this.productStore = productStore;
    }

    public List<Product> getAllProducts() {
        return productStore.getProductList();
    }

    public Optional<Product> saveProduct(Product product) {
        return productStore.saveProduct(product);
    }

    public Optional<Product> findProduct(Long id) {
        return productStore.findById(id);
    }

    // TODO::
    public void updateProduct() {}

    // TODO::
    public void deleteProduct() {}
}
