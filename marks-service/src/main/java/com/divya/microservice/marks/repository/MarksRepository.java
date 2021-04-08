package com.divya.microservice.marks.repository;

import com.divya.microservice.marks.entity.MarksEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MarksRepository extends JpaRepository<MarksEntity, Long> {


    MarksEntity findByStudentId(Long studentId);
}
