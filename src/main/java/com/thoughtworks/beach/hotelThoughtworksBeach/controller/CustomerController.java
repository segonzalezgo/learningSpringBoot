package com.thoughtworks.beach.hotelThoughtworksBeach.controller;

import com.thoughtworks.beach.hotelThoughtworksBeach.domain.Customer;
import com.thoughtworks.beach.hotelThoughtworksBeach.service.CustomerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    private CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/all")
    public List<Customer> retrieveAllCustomers() {
        return customerService.retrieveAllCustomers();
    }

    public Customer createCustomer(Customer customerInformation) {

        return customerService.createCustomer(customerInformation);
    }
}
