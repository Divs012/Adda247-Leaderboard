package com.divya.microservice.marks.service;

import com.divya.microservice.marks.entity.MarksEntity;
import com.divya.microservice.marks.repository.MarksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MarksService {
    @Autowired
    private MarksRepository marksRepository;


    public MarksEntity saveMarks(MarksEntity marksEntity) {
        return marksRepository.save(marksEntity);
    }


    public MarksEntity findByStudentId(Long studentId) {
        return marksRepository.findByStudentId(studentId);

    }


    public List<MarksEntity> getAllMarks() {
        return marksRepository.findAll();
    }

    public void deleteByStudentId(Long studentId) {
        marksRepository.deleteById(studentId);
    }

    public MarksEntity updateMarks(MarksEntity marksEntity) {
        return marksRepository.save(marksEntity);
    }


}

