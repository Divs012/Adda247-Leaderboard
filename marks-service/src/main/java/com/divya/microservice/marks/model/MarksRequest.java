package com.divya.microservice.marks.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MarksRequest {
    @NotNull
    private Long studentId;
    @NotNull
    private String subjectId;
    @NotNull
    private int marks;

}
