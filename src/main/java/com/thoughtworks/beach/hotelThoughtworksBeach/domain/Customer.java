package com.thoughtworks.beach.hotelThoughtworksBeach.domain;

public class Customer {
    private Integer rut;
    private String name;
    private String lastName;

    public Customer() {
    }

    public Customer(Integer rut, String name, String lastName) {
        this.rut = rut;
        this.name = name;
        this.lastName = lastName;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public Integer getRut() {
        return rut;
    }
}
