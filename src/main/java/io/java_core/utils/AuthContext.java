package io.java_core.utils;

import java.util.HashMap;

public class AuthContext {

    private static final HashMap<String, Object> context = new HashMap<>();

    public static <T> void addItem(String key, T item) {
        context.put(key, item);
    }

    public static <T> T getItem(String key) {
        return (T) context.get(key);
    }

    public static void clearContext() {
        context.clear();
    }
}
