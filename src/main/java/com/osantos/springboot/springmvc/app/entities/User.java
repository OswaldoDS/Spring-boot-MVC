package com.osantos.springboot.springmvc.app.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "users")

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String lastname;
    private String email;
    private String username;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    public User() {
    }

    public User(String name, String lastname) {
        this.name = name;
        this.lastname = lastname;
    }

    //Metodo de evento
    @PrePersist
    public void prePersist(){
        this.createdAt = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLastname() {
        return lastname;
    }

    public String getEmail() {
        return email;
    }

    public String getUsername() {
        return username;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}
