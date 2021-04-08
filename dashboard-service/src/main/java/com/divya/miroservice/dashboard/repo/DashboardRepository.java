package com.divya.miroservice.dashboard.repo;

import com.divya.miroservice.dashboard.entity.Dashboard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DashboardRepository extends JpaRepository<Dashboard, Long> {

}
