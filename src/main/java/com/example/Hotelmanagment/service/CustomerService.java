package com.example.Hotelmanagment.service;

import com.example.Hotelmanagment.entity.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> getall();
    void saveCustomer(Customer customer);
    void delation(Long id);
}
