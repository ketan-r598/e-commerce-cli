package io.java_core.models;

import java.util.HashMap;
import java.util.Optional;

// Implemented singleton pattern using Enum
public enum GlobalContext {
    INSTANCE;

    private HashMap<String,Object> context;

    GlobalContext() {
        this.context = new HashMap<>();
    }

    public <T> void  add(String key, T value) {
        context.put(key, value);
    }

    public <T> Optional<T> get(String key) {
        return Optional.ofNullable((T) context.get(key));
    }

    public void clearContext() {
        context.clear();
    }

    public static GlobalContext getInstance() {
        return INSTANCE;
    }

}
