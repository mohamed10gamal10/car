package com.Carrental.car.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Lazy;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data

public class Rental {

    @Id
    @GeneratedValue
    private UUID id;
    @ManyToOne
    @JoinColumn(name="customer_id")
    private Customer customer;
    @ManyToOne
    @JoinColumn(name="car_id")
    private Car car;
    private LocalDate start_date;
    private LocalDate end_date;
    private BigDecimal total_price;
    private String statue;
    private Timestamp created_at;
    @OneToMany(mappedBy = "rental",fetch = FetchType.LAZY)
    private List<Payment> payment;




}
