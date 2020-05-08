package com.local.portfolio.data.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "id")
    private List<Portfolio> portfolios;
}
