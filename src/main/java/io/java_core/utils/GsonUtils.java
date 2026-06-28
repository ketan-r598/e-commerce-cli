package io.java_core.utils;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class GsonUtils {

    private static ExclusionStrategy strategy = new ExclusionStrategy() {
        @Override
        public boolean shouldSkipField(FieldAttributes f) {
            return f.getName().equalsIgnoreCase("password")
                    || f.getName().equalsIgnoreCase("id")
                    ;
        }

        @Override
        public boolean shouldSkipClass(Class<?> clazz) {
            return false;
        }
    };

    private static final Gson gson = new GsonBuilder().addSerializationExclusionStrategy(strategy)
                                                    .setPrettyPrinting().create();

    public static String serialize(Object o) {
        return gson.toJson(o);
    }
}
