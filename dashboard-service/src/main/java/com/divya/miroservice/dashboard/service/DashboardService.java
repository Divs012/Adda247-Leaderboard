package com.divya.miroservice.dashboard.service;

import com.divya.miroservice.dashboard.entity.Dashboard;
import com.divya.miroservice.dashboard.repo.DashboardRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DashboardService {
    @Autowired
    private DashboardRepository dashboardRepository;
Logger logger= LoggerFactory.getLogger(DashboardService.class);



    public void addRecords() {
logger.info("Inside addRecords Service");
        dashboardRepository.addRecord();
    }


    public List<Dashboard> getRecords() {
        logger.info("Inside getRecords Service");
        return dashboardRepository.getRecords();
    }

    public void deleteAll() {
        logger.info("Inside deleteRecords Service");
        dashboardRepository.deleteRecords();
    }
}
