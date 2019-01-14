package com.thoughtworks.beach.hotelThoughtworksBeach.repository;

import java.util.List;

import com.thoughtworks.beach.hotelThoughtworksBeach.repository.model.CustomerEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends CrudRepository<CustomerEntity, Long>{
    List<CustomerEntity> findByLastName(String lastName);
}