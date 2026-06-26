package io.java_core.stores;

import io.java_core.models.User;

import java.util.HashMap;
import java.util.Optional;

public class UserStore {

    private HashMap<String, User> userStoreMap;

    public UserStore() {
        userStoreMap = new HashMap<>();
    }


    public Optional<User> findByEmailId(String email) {
        return Optional.ofNullable(userStoreMap.getOrDefault(email, null));
    }

    public User addUser(User u) {
        if (userStoreMap.containsKey(u.getEmail())) return null;

        else userStoreMap.put(u.getEmail(), u);
        return userStoreMap.get(u.getEmail());
    }


    public User updateUser(User u) {
        userStoreMap.put(u.getEmail(), u);
        return userStoreMap.get(u.getEmail());
    }


    public boolean deleteUser(User u) {
        if (userStoreMap.containsKey(u.getEmail())) {
            userStoreMap.remove(u.getEmail());
            return true;
        }
        return false;
    }
}
