package com.Carrental.car.EntityDto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record RegisterDto(
    String name,
    String password,
    String email
)

{}
