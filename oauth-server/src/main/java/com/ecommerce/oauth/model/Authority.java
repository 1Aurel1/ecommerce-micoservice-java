package com.ecommerce.oauth.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Authority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Enumerated(value = EnumType.STRING)
    private AuthorityName name;

    @OneToMany(mappedBy = "authority")
    private List<User> users;
}
