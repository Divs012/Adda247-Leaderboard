package com.divya.microsevice.subject.repo;

import com.divya.microsevice.subject.model.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectRepo extends JpaRepository<Subject,String> {
}
