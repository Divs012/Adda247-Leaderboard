package com.divya.miroservice.dashboard.controller;

import com.divya.miroservice.dashboard.entity.Dashboard;
import com.divya.miroservice.dashboard.service.DashboardService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/dashboard")
@Component
public class DashboardController {
    Logger logger = LoggerFactory.getLogger(DashboardController.class);
    @Autowired
    private DashboardService dashboardService;
    @GetMapping("/home")

    public String home(){
        logger.info("dashboard called");
        return "Dashboard";
    }

    @GetMapping("/records")
    @Scheduled(cron = "0 */5 * * * *")
    public List<Dashboard> allRecords(){
        logger.info("Fetching Records");

        dashboardService.deleteAll();
        dashboardService.addRecords();
      return dashboardService.getRecords();
    }

}
