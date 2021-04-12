package com.divya.microservice.student.shared;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentDao implements Serializable {
    private static final long serialVersionUID = -5235761189632809402L;
    private String studentName;
    private String password;
    private String email;
    private String encryptedPassword;
}
