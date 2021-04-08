package com.divya.microservice.marks.controller;

import com.divya.microservice.marks.entity.MarksEntity;
import com.divya.microservice.marks.model.MarksRequest;
import com.divya.microservice.marks.service.MarksService;
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

    @GetMapping("/home")
    public String home() {
        return "Welcome home";
    }

    @PostMapping("/add")
    public MarksEntity saveMarks(@Valid @RequestBody MarksRequest marksRequest) {
        MarksEntity marksEntity = new MarksEntity();
        marksEntity.setSubject1(marksRequest.getSubject1());
        marksEntity.setSubject2(marksRequest.getSubject2());
        marksEntity.setSubject3(marksRequest.getSubject3());
        marksEntity.setSubject4(marksRequest.getSubject4());
        marksEntity.setSubject5(marksRequest.getSubject5());
        marksEntity.setTotal(marksRequest.getSubject1() + marksRequest.getSubject2() + marksRequest.getSubject3() + marksRequest.getSubject4() + marksRequest.getSubject5());

        return marksService.saveMarks(marksEntity);


    }

    @GetMapping("/{studentId}")
    @Cacheable(value = "Marks", key = "#studentId")
    public MarksEntity findByStudentId(@PathVariable("studentId") Long studentId) {
        return marksService.findByStudentId(studentId);
    }

    @GetMapping("/all")
    public List<MarksEntity> allMarks() {
        return marksService.getAllMarks();
    }

    @DeleteMapping("/delete/{studentId}")
    @CacheEvict(value = "Marks", allEntries = true)
    public void deleteByStudentId(@PathVariable("studentId") Long studentId) {
        marksService.deleteByStudentId(studentId);

    }

    @PutMapping("/update")
    public MarksEntity UpdateMarks(@RequestBody MarksEntity marksEntity) {
        return marksService.updateMarks(marksEntity);
    }


}
