package com.divya.microservice.marks.controller;

import com.divya.microservice.marks.entity.Marks;
import com.divya.microservice.marks.entity.MarksId;
import com.divya.microservice.marks.model.MarksRequest;
import com.divya.microservice.marks.service.MarksService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/marks")
public class MarksController {
    @Autowired
    private MarksService marksService;
private Logger logger= LoggerFactory.getLogger(MarksController.class);
    @GetMapping("/home")
    public String home() {
        return "Welcome home";
    }

    @PostMapping("/add")
    public Marks saveMarks(@Valid @RequestBody MarksRequest marksRequest) {
        Marks marks = new Marks(new MarksId(marksRequest.getStudentId(),marksRequest.getSubjectId()),
        marksRequest.getMarks());

        return marksService.saveMarks(marks);


    }

    @GetMapping("/{marksId}")
    @Cacheable(value = "Marks", key = "#marksId")
    public Marks findByMarksId(@PathVariable("marksId") MarksId marksId) {
        logger.info("Loading from database {}", marksId);
        return marksService.findByMarksId(marksId);

    }

    @GetMapping("/all")
    public List<Marks> allMarks() {
        return marksService.getAllMarks();
    }

    @DeleteMapping("/delete/{marksId}")
    @CacheEvict(value = "Marks", allEntries = true)
    public void deleteByStudentId(@PathVariable("marksId") MarksId marksId) {
        marksService.deleteByMarksId(marksId);

    }

    @PutMapping("/update")
    public Marks UpdateMarks(@RequestBody MarksRequest marksRequest) {

        Marks marks = new Marks(new MarksId(marksRequest.getStudentId(),marksRequest.getSubjectId()),
                marksRequest.getMarks());

        return marksService.updateMarks(marks);
    }


}
