package com.thoughtworks.beach.hotelThoughtworksBeach.repository.mapper;

import com.thoughtworks.beach.hotelThoughtworksBeach.domain.Customer;
import com.thoughtworks.beach.hotelThoughtworksBeach.repository.model.CustomerEntity;
import org.junit.Test;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class CustomerMapperTest {

    @Test
    public void retrieveDomains() {
        CustomerMapper customerMapper = new CustomerMapper();
        Iterable<CustomerEntity> customerEntities = getCustomersEntity();

        List<Customer> customers = customerMapper.retrieveDomains(customerEntities);

        assertThat(customers).isNotEmpty();
        assertThat(customers.get(0).getName()).isEqualTo("Sergio");
    }

    private Iterable<CustomerEntity> getCustomersEntity() {
        return Collections.singletonList(new CustomerEntity("Sergio", "Gonzalez"));
    }
}