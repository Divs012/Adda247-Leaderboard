package com.divya.microservice.student.model;

import lombok.Data;

@Data
public class LoginRequest {
    public String password;
    private String email;
}
