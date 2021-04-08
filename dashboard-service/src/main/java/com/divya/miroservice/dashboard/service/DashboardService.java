package com.divya.miroservice.dashboard.service;

import com.divya.miroservice.dashboard.entity.Dashboard;
import com.divya.miroservice.dashboard.repo.DashboardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DashboardService {
    @Autowired
    private DashboardRepository dashboardRepository;




    public List<Dashboard> getAllRecords() {

        return dashboardRepository.findAll();
    }


}
