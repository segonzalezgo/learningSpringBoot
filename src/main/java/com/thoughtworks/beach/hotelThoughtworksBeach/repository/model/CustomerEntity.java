package com.thoughtworks.beach.hotelThoughtworksBeach.repository.model;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "customer")
public class CustomerEntity implements Serializable {

    private static final long serialVersionUID = -3009157732242241606L;

    @Id
    private Integer rut;

    @Column(name = "firstname")
    private String firstName;

    @Column(name = "lastname")
    private String lastName;

    public CustomerEntity() {
    }

    public CustomerEntity(Integer rut, String firstName, String lastName) {
        this.rut = rut;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return String.format("CustomerEntity[rut=%d, firstName='%s', lastName='%s']", rut, firstName, lastName);
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Integer getRut() {
        return rut;
    }
}
