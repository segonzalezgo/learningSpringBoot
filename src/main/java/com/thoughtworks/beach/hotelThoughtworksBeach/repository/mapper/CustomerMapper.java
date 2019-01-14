package com.thoughtworks.beach.hotelThoughtworksBeach.repository.mapper;

import com.thoughtworks.beach.hotelThoughtworksBeach.domain.Customer;
import com.thoughtworks.beach.hotelThoughtworksBeach.repository.model.CustomerEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CustomerMapper {
    public List<Customer> retrieveDomains(Iterable<CustomerEntity> customerEntities) {

        List<Customer> customers = new ArrayList<>();

        for (CustomerEntity customerEntity : customerEntities) {
            Customer customer = new Customer(customerEntity.getFirstName(), customerEntity.getLastName());
            customers.add(customer);
        }
        return customers;
    }

    public CustomerEntity convertToEntity(Customer customerDomain) {
        return new CustomerEntity(customerDomain.getName(), customerDomain.getLastName());
    }

    public Customer convertToDomain(CustomerEntity customerEntity) {

        return new Customer(customerEntity.getFirstName(), customerEntity.getLastName());
    }
}
