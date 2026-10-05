package com.Carrental.car.controll;

import com.Carrental.car.Entity.Car;
import com.Carrental.car.impl.CarServiceimpl;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/car")
public class Carcontroler {

    private final CarServiceimpl serviceimpl;

    public Carcontroler(CarServiceimpl serviceimpl) {
        this.serviceimpl = serviceimpl;
    }


    @GetMapping("/allcar")
    public Page<Car> getallcar(Pageable pageable)
    {
       return serviceimpl.getall(pageable);
    }

    @PostMapping("/admin/addcar")
     public void addnewCar( @RequestBody Car car)
    {
        serviceimpl.addnewcar(car);
    }
    
    @GetMapping("/id/{id}")
    public Optional<Car> findbyid(@PathVariable UUID id)
    {
        return serviceimpl.findCarbyid(id);
    }



}
