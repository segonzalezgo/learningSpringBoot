package com.thoughtworks.beach.hotelThoughtworksBeach.repository.mapper;

import com.thoughtworks.beach.hotelThoughtworksBeach.domain.Customer;
import com.thoughtworks.beach.hotelThoughtworksBeach.repository.model.CustomerEntity;
import org.junit.Test;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class CustomerMapperTest {

    @Test
    public void retrievesDomains() {
        CustomerMapper customerMapper = new CustomerMapper();
        Iterable<CustomerEntity> customerEntities = getCustomersEntity();

        List<Customer> customers = customerMapper.retrieveDomains(customerEntities);

        assertThat(customers).isNotEmpty();
        assertThat(customers.get(0).getName()).isEqualTo("Sergio");
    }

    @Test
    public void convertsCustomerDomainToCustomerEntity() {
        Customer customer = new Customer("Victoria", "Fuenmayor");
        CustomerMapper customerMapper = new CustomerMapper();

        CustomerEntity customerEntity = customerMapper.convertToEntity(customer);

        assertThat(customerEntity.getFirstName()).isEqualTo("Victoria");
        assertThat(customerEntity.getLastName()).isEqualTo("Fuenmayor");
    }

    @Test
    public void convertsCustomerEntityIntoCustomerDomain() {
        CustomerEntity customerEntity = new CustomerEntity("Victoria", "Fuenmayor");
        CustomerMapper customerMapper = new CustomerMapper();

        Customer customer = customerMapper.convertToDomain(customerEntity);

        assertThat(customer.getName()).isEqualTo("Victoria");
        assertThat(customer.getLastName()).isEqualTo("Fuenmayor");
    }

    private Iterable<CustomerEntity> getCustomersEntity() {
        return Collections.singletonList(new CustomerEntity("Sergio", "Gonzalez"));
    }
}