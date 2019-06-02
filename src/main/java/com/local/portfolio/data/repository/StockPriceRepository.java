package com.local.portfolio.data.repository;

import com.local.portfolio.data.entity.StockPrice;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StockPriceRepository extends CrudRepository<StockPrice, Long> {
}
