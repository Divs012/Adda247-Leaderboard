package com.divya.microservice.student.controller;

import com.divya.microservice.student.data.StudentEntity;
import com.divya.microservice.student.model.StudentRequest;
import com.divya.microservice.student.model.StudentResponse;
import com.divya.microservice.student.service.StudentService;
import com.divya.microservice.student.shared.StudentDao;
import com.divya.microservice.student.vo.ResponseTemplateVO;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/student")

public class StudentController {
    @Autowired
    private StudentService studentService;
Logger logger= LoggerFactory.getLogger(StudentController.class);
    @PostMapping("/home")
    public String home() {
        return "Student Service";

    }

    @PostMapping("/add")

    public ResponseEntity<StudentResponse> createStudent(@Valid @RequestBody StudentRequest studentRequest) {
        logger.info("Inside add Student");

        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        StudentDao studentDao = modelMapper.map(studentRequest, StudentDao.class);

        StudentDao createdStudent = studentService.createStudent(studentDao);
        StudentResponse returnValue = modelMapper.map(createdStudent, StudentResponse.class);
        logger.info("Student Created", returnValue);
        return ResponseEntity.status(HttpStatus.CREATED).body(returnValue);



    }


    @GetMapping("/{email}")
    @Cacheable(value = "Student", key = "#email")
    public ResponseTemplateVO getStudentWithMarks(@PathVariable(value = "email") String email) {
        logger.info("Getting student with  email{}", email);
        return studentService.getStudentWithMarks(email);


    }

    @GetMapping("/all")
    public ResponseEntity<List<StudentEntity>> getAll() {
        logger.info("Fetching Student", studentService.getAll());
        return ResponseEntity.ok(studentService.getAll());
    }


    @DeleteMapping("/delete/{id}")
    @CacheEvict(value = "Student", allEntries = true)
    public void deleteByStudentId(@PathVariable("id") Long studentId) {
        studentService.deleteById(studentId);
    }

   }

