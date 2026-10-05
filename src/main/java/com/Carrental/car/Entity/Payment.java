package com.Carrental.car.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Payment {

    @Id
    @GeneratedValue
    private UUID id;
    @ManyToOne
    @JoinColumn(name="rental_id",nullable = false)
    private Rental rental;
    @NotNull
    private double amount;
    @NotNull
    private LocalDateTime payment_date;
     @NotNull
    private String payment_methods;
    @NotBlank
    private String statues;
    @NotNull
    private Timestamp created_id;




}
