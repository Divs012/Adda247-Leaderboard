package com.divya.microservice.student.vo;


import com.divya.microservice.student.data.StudentEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseTemplateVO implements Serializable {

    private static final long serialVersionUID = -5647042134498518085L;
    private StudentEntity studentEntity;
    private Marks marks;
}
