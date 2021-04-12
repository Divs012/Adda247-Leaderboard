package com.divya.microservice.marks.repository;

import com.divya.microservice.marks.entity.Marks;
import com.divya.microservice.marks.entity.MarksId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MarksRepository extends JpaRepository<Marks, MarksId> {



}
