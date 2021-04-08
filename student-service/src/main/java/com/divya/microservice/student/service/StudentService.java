package com.divya.microservice.student.service;

import com.divya.microservice.student.data.StudentEntity;
import com.divya.microservice.student.shared.StudentDao;
import com.divya.microservice.student.vo.ResponseTemplateVO;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface StudentService extends UserDetailsService {
    StudentDao createStudent(StudentDao studentDao);


    List<StudentEntity> getAll();

    ResponseTemplateVO getStudentWithMarks(String email);

    void deleteById(Long id);

    StudentEntity getById(Long id);
}
