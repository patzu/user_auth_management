package com.example.userauthenticationmanagement.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Table(name = "users", uniqueConstraints = {
        @UniqueConstraint(columnNames = "email"),
        @UniqueConstraint(columnNames = "userId")})
public class MyUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "{NotBlank.user.userId}")
    @Column(unique = true, nullable = false)
    private String userId;
    @NotBlank(message = "{NotBlank.user.firstName}")
    @Column(nullable = false)
    private String firstName;
    @NotBlank(message = "{NotBlank.user.lastName}")
    @Column(nullable = false)
    private String lastName;
    @Email
    @Column(nullable = false, unique = true)
    @NotBlank(message = "{NotBlank.user.email}")
    private String email;
    @NotBlank(message = "{NotBlank.user.password}")
    @Column(nullable = false)
    private String password;
    @NotBlank(message = "{NotBlank.user.phone}")
    @Column(nullable = false)
    private String phone;
}