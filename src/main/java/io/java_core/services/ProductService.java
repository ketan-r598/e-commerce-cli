package io.java_core.services;

import io.java_core.models.Product;
import io.java_core.stores.ProductStore;

import java.util.List;

public class ProductService {

    private ProductStore productStore;

    public ProductService(ProductStore productStore) {
        this.productStore = productStore;
    }

    public List<Product> getAllProducts() {
        return productStore.getProductList();
    }
    //  TODO::
    public void saveProduct() {}

    // TODO::
    public void updateProduct() {}

    // TODO::
    public void deleteProduct() {}
}
