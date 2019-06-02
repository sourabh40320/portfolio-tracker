package com.local.portfolio.data.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
public class StockPrice {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "symbol")
    private Stock stock;
    
    private Double price;
    private Date date;
    private Date autoUpdateTime;
}
