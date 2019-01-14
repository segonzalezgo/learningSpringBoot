package com.thoughtworks.beach.hotelThoughtworksBeach.repository.mapper;

import com.thoughtworks.beach.hotelThoughtworksBeach.domain.Customer;
import com.thoughtworks.beach.hotelThoughtworksBeach.repository.model.CustomerEntity;

import java.util.ArrayList;
import java.util.List;

public class CustomerMapper {
    public List<Customer> retrieveDomains(Iterable<CustomerEntity> customerEntities) {

        List<Customer> customers = new ArrayList<>();

        for (CustomerEntity customerEntity : customerEntities) {
            Customer customer = new Customer(customerEntity.getFirstName(), customerEntity.getLastName());
            customers.add(customer);
        }
        return customers;
    }

    public CustomerEntity retrieveEntity(Customer customerDomain) {
        return null;
    }

    public Customer retrieveDomain(CustomerEntity customerEntity) {
        return null;
    }
}
