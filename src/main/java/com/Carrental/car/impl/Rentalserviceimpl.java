package com.Carrental.car.impl;

import com.Carrental.car.Entity.Car;
import com.Carrental.car.Enum.CarStatues;
import com.Carrental.car.Entity.Customer;
import com.Carrental.car.Entity.Rental;
import com.Carrental.car.Repositry.CarRepositry;
import com.Carrental.car.Repositry.Customerrepositry;
import com.Carrental.car.Repositry.Rentalrepositry;
import com.Carrental.car.SErvice.Rentalservice;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.UUID;
@Transactional
public class Rentalserviceimpl implements Rentalservice {

    private final Rentalrepositry rentalrepositry;
    private final CarRepositry carRepositry;
    private final Customerrepositry customerrepositry;

    public Rentalserviceimpl(Rentalrepositry rentalrepositry, CarRepositry carRepositry, Customerrepositry customerrepositry) {
        this.rentalrepositry = rentalrepositry;
        this.carRepositry = carRepositry;
        this.customerrepositry = customerrepositry;
    }

    @Override
    public Page<Rental> findall(Pageable pageable) {
        return rentalrepositry.findAll(pageable);
    }

    @Override
    public Rental CreatetheRental(UUID idcustomer, LocalDate startdate, LocalDate endDate, UUID carid) {
         if(startdate.isBefore(endDate))
         {
             throw new IllegalArgumentException("Start Date must be end date");

         }
        Customer customer=customerrepositry.findById(idcustomer).orElseThrow(()->new RuntimeException("Customer not found"));
         Car car=carRepositry.findById(carid).orElseThrow(()->new RuntimeException("Car is not found"));
         if(car.getCarStatues()== CarStatues.Maintence)
         {
             throw new IllegalArgumentException("The car in maintenance");
         }

        List<CarStatues>active=List.of(CarStatues.Avalaible,CarStatues.Rented);
         List<Rental>confict=rentalrepositry.findConflictingRentals(carid,active,startdate,endDate);

         if(!confict.isEmpty())
         {
             throw new IllegalArgumentException("The work not allow");
         }
        long days = ChronoUnit.DAYS.between(startdate, endDate);

        BigDecimal totalPrice =
                BigDecimal.valueOf(car.getPriceinday())
                        .multiply(BigDecimal.valueOf(days));


         Rental rental=new Rental();
         rental.setCustomer(customer);
         rental.setCar(car);
         rental.setStatue(String.valueOf(CarStatues.Rented));
         rental.setStart_date(startdate);
         rental.setEnd_date(endDate);
         rental.setTotal_price(totalPrice);
        return rentalrepositry.save(rental);

    }
}
