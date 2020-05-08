//package com.local.portfolio.service.internal;
//
//import com.local.portfolio.service.external.AlphaVantageRestHelper;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.scheduling.annotation.EnableScheduling;
//import org.springframework.scheduling.annotation.Scheduled;
//
//@Configuration
//@EnableScheduling
//public class ScheduledJob {
//    
//    @Autowired
//    private AlphaVantageRestHelper alphaVantageRestHelper;
//    
//    @Scheduled(cron = "*/30 * * * * *")
//    private void stockPriceFetchJob() {
//        alphaVantageRestHelper.getStockValue("NSE:VGUARD");
//    }
//}
