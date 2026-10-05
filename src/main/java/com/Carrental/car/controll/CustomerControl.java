package com.Carrental.car.controll;


import com.Carrental.car.Entity.Customer;
import com.Carrental.car.SErvice.CustomerService;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/Customer")
public class CustomerControl {

    private final CustomerService customerService;


    public CustomerControl(CustomerService customerService) {
        this.customerService = customerService;

    }

    @PostMapping("/addCustomer")
    public Customer addcustomer(@RequestBody Customer customer)
    {
        return   customerService.addnewCusomer(customer);
    }

    @GetMapping("/id/{id}")
    public Optional<Customer>findcustomer(@PathVariable UUID id)
    {
        return customerService.findCustomerbyid(id);
    }
}
//6f9cd8c3-53f8-479c-bcfd-1eda1775a5f0
//2cf1c7c2-91be-4daf-b5bc-d0a81cfaf99e
