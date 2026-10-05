package com.Carrental.car.EntityDto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import java.util.UUID;

public class loginrequest {
    @NotBlank
    private String password;
    @Email
    @NotBlank
    @Column(unique = true)
    private String email;
}