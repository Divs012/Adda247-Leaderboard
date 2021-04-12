package com.divya.microsevice.subject.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="subject")
public class Subject implements Serializable {

    private static final long serialVersionUID = -5294745658993032113L;
    @Id
    private String subjectId;

    @Column(nullable = false, length = 50)
    private String subjectName;



}
