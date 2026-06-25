package io.java_core.stores;

import io.java_core.models.User;

import java.util.HashMap;
import java.util.Optional;

public class UserStore {

    private HashMap<String, User> userStoreMap;

    public UserStore() {
        userStoreMap = new HashMap<>();
    }

//    TODO::
    public Optional<User> findByEmailId() {return Optional.empty();}

//    TODO::
    public User addUser(User u) {return null;}

//    TODO::
    public User updateUser(User u) {return null;}

//    TODO::
    public boolean deleteUser(User u) {return false;}
}
