package com.Carrental.car.Entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cache;
import org.springframework.objenesis.instantiator.util.UnsafeUtils;

import java.sql.Timestamp;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name="Customer")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

    @Id
    @GeneratedValue
    private UUID id;
    @NotNull

    private String name;
    @Email
    @NotBlank
    private  String email;
    @NotNull
    private  String phone;
    @NotNull
    private String driving_license_number;
    @NotNull
    private Timestamp created_at;
    @OneToMany(mappedBy = "customer",fetch = FetchType.LAZY)
    private Set<Rental> rental;

    @OneToOne(mappedBy = "customer")
    private Acount acount;

}
