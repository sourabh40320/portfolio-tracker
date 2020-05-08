package com.local.portfolio.data.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "stock")
public class Stock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String symbol;

    @Column(nullable = false)
    @CreationTimestamp
    private Date added_on;

    @OneToMany(mappedBy = "id")
    private List<StockPrice> stockPrice;

    @OneToMany
    @JoinColumn(name = "id")
    @JsonIgnore
    private List<PortFolioStockMapping> mappings;
}
