package com.local.portfolio.data.repository;

import com.local.portfolio.data.entity.PortFolioStockMapping;
import org.springframework.data.repository.CrudRepository;

/**
 * @author Sourabh
 **/
public interface PortfolioStockMappingRepository extends CrudRepository<PortFolioStockMapping, Long> {
}
