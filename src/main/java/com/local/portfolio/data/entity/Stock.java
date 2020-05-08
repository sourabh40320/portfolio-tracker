package com.local.portfolio.data.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "stock")
public class Stock {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String symbol;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date added_on;

    @OneToMany(mappedBy = "id")
    private List<StockPrice> stockPrice;
}
