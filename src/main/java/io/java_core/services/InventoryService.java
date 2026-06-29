package io.java_core.services;

import io.java_core.models.InventoryItem;
import io.java_core.models.Product;
import io.java_core.stores.InventoryStore;

import java.util.Optional;

public class InventoryService {
    private final InventoryStore inventoryStore;

    public InventoryService(InventoryStore inventoryStore) {
        this.inventoryStore = inventoryStore;
    }

    public boolean inStock(Product product) {
        return inventoryStore.inStock(product);
    }

    public Optional<InventoryItem> addToStock(InventoryItem item) {
        return inventoryStore.addItem(item);
    }

    public void incrementStock(Product p) {
        inventoryStore.incrementStock(p,1L);
    }

    public void decrementStock(Product p) {
        inventoryStore.decrementStock(p);
    }
}
