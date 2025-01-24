package com.tajbir.Security.model;


import jakarta.annotation.Nonnull;
import jakarta.persistence.*;
import lombok.Generated;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "users")
@Getter
@Setter
public class Users {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(name = "username")
    @Nonnull
    private String username;

    @Column(name = "password")
    @Nonnull
    private String password;
}
