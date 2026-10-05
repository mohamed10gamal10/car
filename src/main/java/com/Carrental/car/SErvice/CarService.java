package com.Carrental.car.SErvice;

import com.Carrental.car.Entity.Car;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
@Service
public interface CarService {
    Page<Car> getall(Pageable pageable);
    Optional< Car> findCarbyid(UUID id);
   Car findbymodelandprand(String model, String prand, UUID id);
  Page<Car> findbyyear(String year, UUID id,Pageable pageable);
     Page<Car> findbypriceinday(Long price,UUID id,Pageable pageable);
    void addnewcar(Car car);
    void deletbyid(UUID id);
    void deleteall();


}
