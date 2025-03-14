package me.dentaloffice.model;

import java.security.Timestamp;

public class User {
    private int id;
    private String username;
    private String email;
    private String passwordHash;
    private UserRole role;
    private boolean isActive;
    private Timestamp createdAt;
    private Timestamp updatedAt;
    private Timestamp lastLogin;

    public User() {}

    public User(int id, String username, String email, String passwordHash, UserRole role, boolean isActive, Timestamp createdAt, Timestamp updatedAt, Timestamp lastLogin) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.passwordHash = passwordHash;
        this.role = role;
        this.isActive = isActive;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.lastLogin = lastLogin;
    }
}
