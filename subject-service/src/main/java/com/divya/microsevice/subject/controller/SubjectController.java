package com.divya.microsevice.subject.controller;

import com.divya.microsevice.subject.model.Subject;
import com.divya.microsevice.subject.service.SubjectService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/subject")
public class SubjectController {
    
 @Autowired
private SubjectService subjectService;
    private Logger logger= LoggerFactory.getLogger(SubjectController.class);
    @GetMapping("/home")

    public String home() {
        logger.info("Home");
        return "Welcome home";
    }

    @PostMapping("/add")

    public Subject saveSubject(@Valid @RequestBody Subject subject) {
     

        return subjectService.saveSubject(subject);


    }

    @GetMapping("/{subjectId}")
    @Cacheable(value = "Subject", key = "#subjectId")
    public Subject findBySubjectId(@PathVariable("subjectId") String subjectId) {
        logger.info("Loading from database {}", subjectId);
        return subjectService.findBySubjectId(subjectId);

    }

    @GetMapping("/all")
    public List<Subject> allSubject() {
        return subjectService.getAllSubject();
    }

    @DeleteMapping("/delete/{subjectId}")
    @CacheEvict(value = "Subject", allEntries = true)
    public void deleteBySubjectId(@PathVariable("subjectId") String subjectId) {
        subjectService.deleteBySubjectId(subjectId);

    }

    @PutMapping("/update")
    public Subject UpdateMarks(@RequestBody Subject subject) {
        return subjectService.updateSubject(subject);
    }
}

