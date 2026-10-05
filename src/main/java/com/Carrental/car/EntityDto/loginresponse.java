package com.Carrental.car.EntityDto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class loginresponse {
    @NotBlank
    private String name;
    @Email
    @NotBlank
    @Column(unique = true)
    private String email;
}
