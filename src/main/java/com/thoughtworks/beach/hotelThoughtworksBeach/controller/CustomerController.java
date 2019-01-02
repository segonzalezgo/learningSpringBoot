package com.thoughtworks.beach.hotelThoughtworksBeach.controller;

import com.thoughtworks.beach.hotelThoughtworksBeach.domain.Customer;
import com.thoughtworks.beach.hotelThoughtworksBeach.service.CustomerService;

import java.util.List;

public class CustomerController {

    private CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    public List<Customer> retrieveAllCustomers() {
        return customerService.retrieveAllCustomers();
    }
}
