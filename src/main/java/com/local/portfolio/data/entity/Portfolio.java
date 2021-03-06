package com.local.portfolio.data.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

/**
 * @author Sourabh
 **/
@Data
@Entity
@Table(name = "portfolio")
public class Portfolio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(referencedColumnName = "id")
    @JsonIgnore
    private User user;

    @OneToMany
    @JoinColumn(name = "id")
    @JsonProperty(value = "stocks")
    private List<PortFolioStockMapping> mappings;

    @Transient
    private Long userId;
}
