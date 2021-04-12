package com.divya.microservice.student.shared;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student implements Serializable {
    private static final long serialVersionUID = -6975627760989470843L;
    private String studentName;
    private String password;
    private String encryptedPassword;
}
