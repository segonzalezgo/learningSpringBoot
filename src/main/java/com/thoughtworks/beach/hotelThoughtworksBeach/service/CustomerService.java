package com.thoughtworks.beach.hotelThoughtworksBeach.service;

import com.thoughtworks.beach.hotelThoughtworksBeach.domain.Customer;
import com.thoughtworks.beach.hotelThoughtworksBeach.repository.CustomerRepository;
import com.thoughtworks.beach.hotelThoughtworksBeach.repository.mapper.CustomerMapper;
import com.thoughtworks.beach.hotelThoughtworksBeach.repository.model.CustomerEntity;

import java.util.List;

public class CustomerService {
    private CustomerRepository customerRepository;
    private CustomerMapper customerMapper;

    public CustomerService(CustomerRepository customerRepository, CustomerMapper customerMapper) {
        this.customerRepository = customerRepository;
        this.customerMapper = customerMapper;
    }

    public List<Customer> retrieveAllCustomers() {

        Iterable<CustomerEntity> customerEntities = customerRepository.findAll();

        return customerMapper.retrieveDomains(customerEntities);
    }

    public Customer createCustomer(Customer customerDomain) {
        CustomerEntity customerEntity = customerMapper.convertToEntity(customerDomain);
        CustomerEntity savedCustomer = customerRepository.save(customerEntity);
        return customerMapper.convertToDomain(savedCustomer);
    }
}
