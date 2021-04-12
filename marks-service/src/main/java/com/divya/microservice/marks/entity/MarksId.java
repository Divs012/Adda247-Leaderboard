package com.divya.microservice.marks.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import java.io.Serializable;
@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MarksId implements Serializable {
    private static final long serialVersionUID = 7445407948258315397L;

    private Long studentId;
    private String subjectName;

}
