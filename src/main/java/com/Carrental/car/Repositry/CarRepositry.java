package com.Carrental.car.Repositry;

import com.Carrental.car.Entity.Car;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface CarRepositry extends JpaRepository<Car,UUID> {

    @Query("SELECT c FROM Car c WHERE c.model = :model AND c.prand = :prand")
    Car findByModelAndPrand(@Param("model") String model,@Param("prand") String prand);
    Page< Car> findByYear(String year, Pageable pageable);
   Page< Car> findByPriceinday(Long priceinday,Pageable pageable);

}
