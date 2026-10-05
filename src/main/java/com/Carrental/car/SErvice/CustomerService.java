package com.Carrental.car.SErvice;

import com.Carrental.car.Entity.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;
import java.util.UUID;

public interface CustomerService {


    Page<Customer> getall(Pageable pageable);
    Optional< Customer> findCustomerbyid(UUID id);
    Customer addnewCusomer(Customer customer );
    void deletbyid(UUID id);
    void deleteall();





}
