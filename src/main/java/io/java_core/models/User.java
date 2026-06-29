package io.java_core.models;

import io.java_core.utils.GsonUtils;

import java.util.Objects;
import java.util.UUID;

public class User {
    private final Long id;
    private String name;
    private String email;
    private Role role;
    private String password;
    private String address;


    public User(String name, String email, String password, String address) {

        Objects.requireNonNull(name);
        Objects.requireNonNull(email);
        Objects.requireNonNull(password);
        Objects.requireNonNull(address);

        this.id = UUID.randomUUID().getMostSignificantBits() & Long.MAX_VALUE;
        this.name = name;
        this.email = email;
        this.password = password;
        this.address = address;

//      By default, every new user will have the role of user. Admins can later change the role to
//      admin, if at all required.
        this.role = Role.USER;
    }


//  Getters

    public String getName() {
        return name;
    }

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public Role getRole() {
        return role;
    }

    public String getPassword() {
        return password;
    }

    public String getAddress() {
        return address;
    }


//  Setters

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAddress(String address) {
        this.address = address;
    }



    @Override
    public boolean equals(Object o) {
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
       return GsonUtils.serialize(this);
    }
}
