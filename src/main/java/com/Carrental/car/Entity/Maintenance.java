package com.Carrental.car.Entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Maintenance {

    @Id
    @GeneratedValue
    private UUID id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "car_id",nullable = false)
    private Car carMaintenance;
    @NotBlank
    private String description;
    @NotNull
    private double cost;
    @NotNull
    private LocalDateTime maintence_date;
    @NotNull
    private Timestamp created_at;



}
