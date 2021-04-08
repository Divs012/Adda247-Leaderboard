package com.divya.microservice.student.data;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "student")

public class StudentEntity implements Serializable {
    private static final long serialVersionUID = 7876899310346591074L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, length = 50)
    private String studentName;
    @Column(nullable = false, length = 100, unique = true)
    private String email;
    @Column(nullable = false, length = 50, unique = true)
    private String studentId;
    @Column(nullable = false, unique = true)
    private String encryptedPassword;
}
