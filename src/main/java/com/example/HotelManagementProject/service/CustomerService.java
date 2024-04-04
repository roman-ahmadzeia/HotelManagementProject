package com.example.HotelManagementProject.service;

import com.example.HotelManagementProject.model.Customer;
import com.example.HotelManagementProject.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository)
    {
        this.customerRepository = customerRepository;
    }

    public List<Customer> getCustomers()
    {
        return customerRepository.findAll();
    }

    public void addCustomer(Customer customer)
    {
        customerRepository.save(customer);
    }



}


