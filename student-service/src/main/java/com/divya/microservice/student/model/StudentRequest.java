package com.divya.microservice.student.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentRequest {


    @NotNull(message = " can't ne null")
    @Size(min = 2, message = "Name can't be less than 2 character")
    private String studentName;
    @NotNull(message = "can't be null")
    @Size(min = 8, max = 16, message = "Password must be equal or greater than 8 and less than 16 characters")
    private String password;
    @NotNull(message = "can't be null")
    @Email
    private String email;

}
