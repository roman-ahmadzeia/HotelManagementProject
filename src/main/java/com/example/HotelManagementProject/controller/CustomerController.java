package com.example.HotelManagementProject.controller;

import com.example.HotelManagementProject.model.Customer;
import com.example.HotelManagementProject.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping(path = "api/customer")
public class CustomerController {
    private final CustomerService customerService;
    @Autowired
    public CustomerController(CustomerService customerService)
    {
        this.customerService = customerService;
    }
    @GetMapping
    public List<Customer> getCustomers()
    {
        return customerService.getCustomers();
    }

}
