package com.project.webgiasu.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "users")
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column(unique = true)
    private String username;

    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;

    public enum Role {
        ADMIN, PARENTS, TUTORS
    }
}

