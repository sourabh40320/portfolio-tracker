package com.local.portfolio.data.entity;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String name;

    @CreationTimestamp
    @Column(nullable = false)
    private Date registeredOn;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "id")
    private List<Portfolio> portfolios;
}
