package com.local.portfolio.data.repository;

import com.local.portfolio.data.entity.Portfolio;
import org.springframework.data.repository.CrudRepository;

/**
 * @author Sourabh
 **/
public interface PortfolioRepository extends CrudRepository<Portfolio, Long> {
}
