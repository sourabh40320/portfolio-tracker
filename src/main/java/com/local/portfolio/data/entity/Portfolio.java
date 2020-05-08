package com.local.portfolio.data.entity;

import javax.persistence.*;

/**
 * @author Sourabh
 **/
@Entity
@Table(name = "portfolio")
public class Portfolio {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private Long userId;

    @Column(nullable = false)
    private Long quantity;

    @ManyToOne
    @JoinColumn(referencedColumnName = "id")
    private Stock stock;
}
