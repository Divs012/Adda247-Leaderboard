package com.divya.microservice.marks.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "marks")
public class Marks implements Serializable {
    private static final long serialVersionUID = -8912512807626299148L;
    @EmbeddedId
    private MarksId marksId;

    @Column(name="marks")
    private int marks;




}
