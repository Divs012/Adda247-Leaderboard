package com.divya.microservice.marks.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "marks")
public class MarksEntity implements Serializable {
    private static final long serialVersionUID = -8912512807626299148L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long studentId;
    @Column
    @NotNull(message = "Can't be null")
    private int subject1;
    @NotNull(message = "Can't be null")
    @Column
    private int subject2;
    @NotNull(message = "Can't be null")
    @Column
    private int subject3;
    @NotNull(message = "Can't be null")
    @Column
    private int subject4;
    @NotNull(message = "Can't be null")
    @Column
    private int subject5;
    @Column
    @NotNull
    private int total;

//@OneToOne
//    @MapsId
//    @JoinColumn(name="studentId")
//    private Student student;

}
