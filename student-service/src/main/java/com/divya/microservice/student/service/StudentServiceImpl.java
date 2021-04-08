package com.divya.microservice.student.service;

import com.divya.microservice.student.data.StudentEntity;
import com.divya.microservice.student.data.StudentRepository;
import com.divya.microservice.student.shared.StudentDao;
import com.divya.microservice.student.vo.Marks;
import com.divya.microservice.student.vo.ResponseTemplateVO;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class StudentServiceImpl implements StudentService {
    RestTemplate restTemplate;
    StudentRepository studentRepository;
    BCryptPasswordEncoder bCryptPasswordEncoder;
    Logger logger= LoggerFactory.getLogger(StudentServiceImpl.class);

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository, RestTemplate restTemplate, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.studentRepository = studentRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.restTemplate = restTemplate;
    }

    @Override
    public StudentDao createStudent(StudentDao studentDao) {
        
        studentDao.setStudentId(UUID.randomUUID().toString());
        studentDao.setEncryptedPassword(bCryptPasswordEncoder.encode(studentDao.getPassword()));
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        StudentEntity studentEntity = modelMapper.map(studentDao, StudentEntity.class);

        studentRepository.save(studentEntity);
        StudentDao returnValue = modelMapper.map(studentEntity, StudentDao.class);
        return returnValue;
    }

    @Override
    public List<StudentEntity> getAll() {
        return studentRepository.findAll();
    }

    @Override
    public ResponseTemplateVO getStudentWithMarks(String email) {

        ResponseTemplateVO vo = new ResponseTemplateVO();
        StudentEntity studentEntity = studentRepository.findByEmail(email);
       System.out.println( studentEntity.getId());
        Marks marks =
                restTemplate.getForObject("http://MARKS-SERVICE/marks/" + studentEntity.getId()
                        , Marks.class);
System.out.println(marks);
        vo.setStudentEntity(studentEntity);
        vo.setMarks(marks);
        return vo;
    }

    @Override
    public void deleteById(Long id) {
        studentRepository.deleteById(id);
    }

    @Override
    public StudentEntity getById(Long id) {
        return studentRepository.findById(id).get();
    }


    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        StudentEntity studentEntity = studentRepository.findByEmail(s);
        if (studentEntity == null) throw new UsernameNotFoundException(s);

        return new User(studentEntity.getEmail(), studentEntity.getEncryptedPassword(), true, true, true, true, new ArrayList<>());
    }

}
