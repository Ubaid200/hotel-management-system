package com.example.Hotelmanagment.controller;

import com.example.Hotelmanagment.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.example.Hotelmanagment.entity.Customer;


@Controller
@RequestMapping("/admin")
public class CustomerController{
    @Autowired
    private CustomerService customerService;
    @GetMapping("/customers")
    public String listcustomer(Model model){
        model.addAttribute("customers",customerService.getall());
        model.addAttribute("newCustomer", new Customer());
        return "/admin/customers";
    }
    @PostMapping("/customers/save")
    public String saveCustomer(@ModelAttribute("newCustomer") Customer customer){
        customerService.saveCustomer(customer);
        return "redirect:/admin/customers";
    }
    @GetMapping("/customers/delete/{id}")
    public String delating(@PathVariable Long id){
        customerService.delation(id);
        return "redirect:/admin/customers";
    }


}