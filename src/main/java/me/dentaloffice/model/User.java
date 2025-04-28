package me.dentaloffice.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String username;
    private String email;
    @Column(name = "password_hash")
    private String passwordHash;
    @Enumerated(EnumType.STRING)
    @Column(name = "role_id")
    private UserRole role;
    @Column(name = "is_active")
    private boolean isActive;
    @Column(name = "created_at")
    private LocalDateTime createdAt;
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
    @Column(name = "last_login")
    private LocalDateTime lastLogin;

    public User() {}

    public User(int id, String username, String email, String passwordHash, UserRole role, boolean isActive, LocalDateTime createdAt, LocalDateTime updatedAt, LocalDateTime lastLogin) {
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
