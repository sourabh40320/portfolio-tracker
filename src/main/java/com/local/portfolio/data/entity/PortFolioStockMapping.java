package com.local.portfolio.data.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

/**
 * @author Sourabh
 **/
@Data
@Entity
public class PortFolioStockMapping {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private Long id;

    @ManyToOne
    @JoinColumn(referencedColumnName = "id")
    @JsonIgnore
    private Portfolio portfolio;

    @ManyToOne
    @JoinColumn(referencedColumnName = "id")
    private Stock stock;

    @Column(nullable = false)
    private Long quantity;

    @Transient
    private Long portfolioId;

    @Transient
    private Long stockId;
}
