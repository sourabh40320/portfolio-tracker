package com.local.portfolio.controller;

import com.local.portfolio.data.entity.PortFolioStockMapping;
import com.local.portfolio.data.entity.Portfolio;
import com.local.portfolio.data.entity.Stock;
import com.local.portfolio.data.entity.User;
import com.local.portfolio.data.repository.PortfolioRepository;
import com.local.portfolio.data.repository.PortfolioStockMappingRepository;
import com.local.portfolio.data.repository.StockRepository;
import com.local.portfolio.data.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

/**
 * @author Sourabh
 **/
@RestController
public class PortfolioController {

    @Autowired
    private PortfolioRepository portfolioRepository;

    @Autowired
    private PortfolioStockMappingRepository psmRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private StockRepository stockRepository;

    @PostMapping("portfolio")
    public Portfolio create(@RequestBody Portfolio portfolio) throws Throwable {
        Optional<User> user = userRepository.findById(portfolio.getUserId());

        user.orElseThrow((Supplier<Throwable>) () -> null);
        portfolio.setUser(user.get());
        return portfolioRepository.save(portfolio);
    }

    @PostMapping("portfolio/add")
    public List<PortFolioStockMapping> add(@RequestBody List<PortFolioStockMapping> portFolioStockMappings) {
        List<Long> portfolioIds = portFolioStockMappings.stream()
                .map(PortFolioStockMapping::getPortfolioId).distinct().collect(Collectors.toList());
        List<Portfolio> portfolios = (List<Portfolio>) portfolioRepository.findAllById(portfolioIds);
        Map<Long, Portfolio> portfolioMap = portfolios.stream()
                .collect(Collectors.toMap(Portfolio::getId, Function.identity()));
        for (PortFolioStockMapping mapping : portFolioStockMappings) {
            Portfolio portfolio = portfolioMap.get(mapping.getPortfolioId());
            mapping.setPortfolio(portfolio);
        }

        List<Long> stockIds = portFolioStockMappings.stream()
                .map(PortFolioStockMapping::getStockId).distinct().collect(Collectors.toList());
        List<Stock> stockList = (List<Stock>) stockRepository.findAllById(stockIds);
        Map<Long, Stock> stockMap = stockList.stream()
                .collect(Collectors.toMap(Stock::getId, Function.identity()));
        for (PortFolioStockMapping mapping : portFolioStockMappings) {
            Stock stock = stockMap.get(mapping.getStockId());
            mapping.setStock(stock);
        }
        return (List<PortFolioStockMapping>) psmRepository.saveAll(portFolioStockMappings);
    }
}
