package com.divya.microsevice.subject.service;

import com.divya.microsevice.subject.model.Subject;
import com.divya.microsevice.subject.repo.SubjectRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SubjectServiceImpl implements SubjectService{
    @Autowired
   private  SubjectRepo subjectRepo;
    @Override
    public Subject saveSubject(Subject subject){
        return subjectRepo.save(subject);
    }

    @Override
    public Subject findBySubjectId(String subjectId) {
        return subjectRepo.findById(subjectId).get();
    }

    @Override
    public List<Subject> getAllSubject() {
        return subjectRepo.findAll();
    }

    @Override
    public Subject updateSubject(Subject subject) {
        return subjectRepo.save(subject);
    }

    @Override
    public void deleteBySubjectId(String subjectId) {

        subjectRepo.deleteById(subjectId);

    }
}
