package com.thoughtworks.beach.hotelThoughtworksBeach.controller;

import com.thoughtworks.beach.hotelThoughtworksBeach.domain.Customer;
import com.thoughtworks.beach.hotelThoughtworksBeach.service.CustomerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class CustomerControllerTest {

    @Mock
    CustomerService customerService;

    @Test
    public void retrieveAllCustomers() {
        CustomerController customerController = new CustomerController(customerService);
        when(customerService.retrieveAllCustomers()).thenReturn(getCustomers());

        List<Customer> customersList = customerController.retrieveAllCustomers();

        assertThat(customersList).isNotEmpty();
        verify(customerService, times(1)).retrieveAllCustomers();
    }

    @Test
    public void callsCreateCustomer() {
        CustomerController customerController = new CustomerController(customerService);
        Customer customerInformation = new Customer("Gaspar", "Loco");

        when(customerService.createCustomer(any(Customer.class))).thenReturn(customerInformation);

        Customer customer = customerController.createCustomer(customerInformation);

        assertThat(customer).isNotNull();
        verify(customerService, times(1)).createCustomer(customer);
    }

    private List<Customer> getCustomers() {
        return Collections.singletonList(new Customer());
    }
}