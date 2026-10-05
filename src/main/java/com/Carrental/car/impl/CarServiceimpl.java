package com.Carrental.car.impl;

import com.Carrental.car.Entity.Car;
import com.Carrental.car.Exaption.ErrorREsponseExaption;
import com.Carrental.car.Repositry.CarRepositry;
import com.Carrental.car.SErvice.CarService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;
@Service
public class CarServiceimpl implements CarService {

    private CarRepositry carRepositry;

    public CarServiceimpl(CarRepositry carRepositry) {
        this.carRepositry = carRepositry;
    }


    @Override
    public Page<Car> getall(Pageable pageable) {
        return carRepositry.findAll(pageable);
    }

    @Override
    public Optional<Car> findCarbyid(UUID id) {
        Car car=carRepositry.findById(id).orElseThrow(()->new ErrorREsponseExaption(" This Car not found "));
        return carRepositry.findById(id);
    }

    @Override
    public Car findbymodelandprand(String model, String prand, UUID id) {
        Car car=carRepositry.findById(id).orElseThrow(()->new ErrorREsponseExaption("Model or prand not found "+model+" "+ prand));
        return carRepositry.findByModelAndPrand(model,prand);
    }

    public Page<Car> findbyyear(String year, UUID id,Pageable pageable) {
       Car car=carRepositry.findById(id).orElseThrow(()->new ErrorREsponseExaption("Car not found"));
       return carRepositry.findByYear(year,pageable);
    }

    @Override
    public Page< Car> findbypriceinday(Long price,UUID id,Pageable pageable) {
        Car car=carRepositry.findById(id).orElseThrow(()-> new ErrorREsponseExaption("Car not found"));
        return carRepositry.findByPriceinday(price,pageable);
    }

    @Override
    public void addnewcar(Car car) {
        carRepositry.save(car);
    }

    @Override
    public void deletbyid(UUID id) {
       carRepositry.deleteById(id);
    }

    @Override
    public void deleteall() {
    carRepositry.deleteAll();
    }


}
