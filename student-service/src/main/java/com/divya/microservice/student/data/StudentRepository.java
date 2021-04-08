package com.divya.microservice.student.data;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<StudentEntity, Long> {
    StudentEntity findByEmail(String email);


}
