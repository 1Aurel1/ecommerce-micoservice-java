package com.ecommerce.oauth.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(unique = true)
    private String username;
    @Column(unique = true)
    private String email;
    private String name;
    private String surname;
    private String password;
    private boolean enabled;

    @ManyToOne(optional = false)
    @JoinColumn(name = "authority_id")
    private Authority authority;
}

