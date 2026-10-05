package com.Carrental.car.Repositry;

import com.Carrental.car.Entity.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;
@Repository
public interface Customerrepositry extends JpaRepository<Customer, UUID> {

    List<Customer> findByName(String name);
    Customer findByPhone(String phone);
    Customer findByEmail(String email);
    @Query("update Customer c  set c.email=:email where c.id=:id ")
    Customer UpdateEmailById(@Param("email") String email,@Param("id") UUID id);

}
