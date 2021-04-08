package com.divya.microservice.student.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Marks implements Serializable {

    private static final long serialVersionUID = 4676668827390959818L;
    private long studentId;

    private int subject1;

    private int subject2;

    private int subject3;

    private int subject4;

    private int subject5;
    private int total;
}
