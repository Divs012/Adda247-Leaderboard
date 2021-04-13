package com.divya.microservice.marks.service;

import com.divya.microservice.marks.entity.Marks;
import com.divya.microservice.marks.entity.MarksId;
import com.divya.microservice.marks.repository.MarksRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Cacheable(cacheNames = "Marks")
public class MarksService {
    @Autowired
    private MarksRepository marksRepository;

Logger logger= LoggerFactory.getLogger(MarksService.class);
    public Marks saveMarks(Marks marks)
    { logger.info("Inside saveMarks service ");
        return marksRepository.save(marks);
    }




    public List<Marks> getAllMarks() {
        logger.info("Inside getAllMarks service ");
        return marksRepository.findAll();
    }


    public void deleteByMarksId(MarksId marksId) {
        logger.info("Inside deleteMarksById service {}",marksId);
        marksRepository.deleteById(marksId);
    }

    public Marks findByMarksId(MarksId marksId) {
        logger.info("Inside findMarks service {}",marksId);
      return   marksRepository.findById(marksId).get();
    }

    public Marks updateMarks(Marks marks) {
        logger.info("Inside updateMarks service ");
      return   marksRepository.save(marks);
    }
}

