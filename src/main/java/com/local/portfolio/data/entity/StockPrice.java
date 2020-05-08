package com.local.portfolio.data.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "stock_price")
public class StockPrice {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, updatable = false, insertable = false)
    private Long stockId;

    @Column(nullable = false)
    private Double price;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date updated_on;

}
