package io.java_core.stores;

import io.java_core.models.InventoryItem;
import io.java_core.models.Product;

import java.util.HashMap;
import java.util.Optional;

public class InventoryStore {
    private final HashMap<Long, InventoryItem> inventoryStore;

    public InventoryStore() {
        inventoryStore = new HashMap<>();
    }

    public boolean inStock(Product product) {
        if(inventoryStore.containsKey(product.getProductId())) {
            return inventoryStore.get(product.getProductId()).getQuantity() > 0;
        }
        return false;
    }

    public Optional<InventoryItem> addItem(InventoryItem item) {
        return Optional.ofNullable(inventoryStore.putIfAbsent(item.getProductId(),item));
    }

    public void incrementStock(Product p, long quantity) {
        if(inventoryStore.containsKey(p.getProductId())) {
            InventoryItem item = inventoryStore.get(p.getProductId());
            item.setQuantity(item.getQuantity() + quantity);
            inventoryStore.put(p.getProductId(), item);
        }
    }

    public void decrementStock(Product p) {
        if(inventoryStore.containsKey(p.getProductId())) {
            InventoryItem item = inventoryStore.get(p.getProductId());
            if(item.getQuantity() - 1 > 0) {
                item.setQuantity(item.getQuantity() + 1);
                inventoryStore.put(p.getProductId(), item);
            }
        }
    }
}
