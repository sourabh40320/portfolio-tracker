package com.local.portfolio.controller;

import com.local.portfolio.data.entity.Stock;
import com.local.portfolio.data.repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Sourabh
 **/
@RestController
public class StockController {

    @Autowired
    private StockRepository stockRepository;

    @PostMapping("stock")
    public Stock add(@RequestBody Stock stock) {
        return stockRepository.save(stock);
    }
}
