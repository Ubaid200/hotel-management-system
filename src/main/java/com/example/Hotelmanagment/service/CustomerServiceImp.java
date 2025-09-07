package com.example.Hotelmanagment.service;

import com.example.Hotelmanagment.entity.Customer;
import com.example.Hotelmanagment.repo.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CustomerServiceImp implements CustomerService{
    @Autowired
    private CustomerRepo customerRepo;
    @Override
    public List<Customer> getall() {
        return customerRepo.findAll();
    }

    @Override
    public void saveCustomer(Customer customer) {
       customerRepo.save(customer);
    }

    @Override
    public void delation(Long id) {
     customerRepo.deleteById(id);
    }
}
