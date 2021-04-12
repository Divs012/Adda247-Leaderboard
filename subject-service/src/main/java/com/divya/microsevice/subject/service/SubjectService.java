package com.divya.microsevice.subject.service;

import com.divya.microsevice.subject.model.Subject;

import java.util.List;

public interface SubjectService {
    Subject saveSubject(Subject subject);

    Subject findBySubjectId(String subjectId);

    List<Subject> getAllSubject();

    Subject updateSubject(Subject subject);
    void deleteBySubjectId(String  subjectId);
}
