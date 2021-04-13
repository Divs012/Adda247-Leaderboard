package com.divya.miroservice.dashboard.repo;

import com.divya.miroservice.dashboard.entity.Dashboard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository

public interface DashboardRepository extends JpaRepository<Dashboard, Long> {
    @Modifying

    @Query(nativeQuery = true,value = "insert into dashboard  select  student.student_name ,sum(marks) as total from marks inner join student on student.student_id=marks.student_id group by marks.student_id order by total desc")
    @Transactional
    void addRecord();
@Query(nativeQuery = true, value="Select * from dashboard limit 10")
    List<Dashboard> getRecords();
@Modifying
@Transactional
    @Query(nativeQuery = true, value="delete from dashboard")
    void deleteRecords();
}
