package com.benisamuel.www.model;

import com.benisamuel.www.enums.Role;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String password;

    @Column(unique = true)
    private String email;

    @Enumerated(EnumType.STRING)
    private Role role;

    public User (String user_name, String user_email, String user_password, Role role) {
        this.name = user_name;
        this.email = user_email;
        this.password = user_password;
        this.role = role;
    }
}
