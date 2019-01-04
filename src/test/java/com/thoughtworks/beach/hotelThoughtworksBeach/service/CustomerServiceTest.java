package com.thoughtworks.beach.hotelThoughtworksBeach.service;

import com.thoughtworks.beach.hotelThoughtworksBeach.domain.Customer;
import com.thoughtworks.beach.hotelThoughtworksBeach.repository.CustomerRepository;
import com.thoughtworks.beach.hotelThoughtworksBeach.repository.mapper.CustomerMapper;
import com.thoughtworks.beach.hotelThoughtworksBeach.repository.model.CustomerEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CustomerServiceTest {

    @Mock
    CustomerRepository customerRepository;
    @Mock
    CustomerMapper customerMapper;

    @Test
    public void retrieveAllCustomers() {
        CustomerService customerService = new CustomerService(customerRepository, customerMapper);
        List<CustomerEntity> customerEntities = getCustomersEntity();
        when(customerRepository.findAll()).thenReturn(customerEntities);
        when(customerMapper.map(customerEntities)).thenReturn(getCustomers());

        List<Customer> customersList = customerService.retrieveAllCustomers();

        assertThat(customersList).isNotEmpty();
        verify(customerRepository).findAll();
    }

    private List<CustomerEntity> getCustomersEntity() {
        return Collections.singletonList(new CustomerEntity("Sergio","Gonzalez"));
    }
    private List<Customer> getCustomers() {
        return Collections.singletonList(new Customer("Sergio","Gonzalez"));
    }

}