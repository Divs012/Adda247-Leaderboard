package com.divya.microservice.marks.service;

import com.divya.microservice.marks.entity.Marks;
import com.divya.microservice.marks.entity.MarksId;
import com.divya.microservice.marks.repository.MarksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Cacheable(cacheNames = "Marks")
public class MarksService {
    @Autowired
    private MarksRepository marksRepository;


    public Marks saveMarks(Marks marks)
    {
        return marksRepository.save(marks);
    }




    public List<Marks> getAllMarks() {
        return marksRepository.findAll();
    }


    public void deleteByMarksId(MarksId marksId) {
        marksRepository.deleteById(marksId);
    }

    public Marks findByMarksId(MarksId marksId) {
      return   marksRepository.findById(marksId).get();
    }

    public Marks updateMarks(Marks marks) {
      return   marksRepository.save(marks);
    }
}

