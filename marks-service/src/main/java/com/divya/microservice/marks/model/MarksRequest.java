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
    private long studentId;
    @NotNull
    private int subject1;
    @NotNull
    private int subject2;
    @NotNull
    private int subject3;
    @NotNull
    private int subject4;
    @NotNull
    private int subject5;

}
