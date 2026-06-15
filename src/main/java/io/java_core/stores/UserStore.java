package io.java_core.stores;

import io.java_core.models.User;

import java.util.HashMap;
import java.util.Optional;

public class UserStore {

    private HashMap<String, User> userStoreMap;

    public UserStore() {
        userStoreMap = new HashMap<>();
    }

    public Optional<User> findById(Long id) {
        return Optional.ofNullable(userStoreMap.get(id));
    }

    public Optional<User> findByEmail(String email) {
        return userStoreMap.values()
                                .stream()
                                .filter(u -> u.getEmail().equalsIgnoreCase(email))
                                .findFirst();
    }

    public Optional<User> saveUser(User user) {
        Optional<User> _user = findByEmail(user.getEmail());

        if(_user.isPresent()) return Optional.empty();
        userStoreMap.put(user.getId(), user);
        return Optional.of(userStoreMap.get(user.getId()));
    }

//    TODO::
    public Optional<User> deleteUser(User user) { return Optional.empty();}

//    TODO::
    public Optional<User> updateUser(User updatedUser) {return Optional.empty();}


}
