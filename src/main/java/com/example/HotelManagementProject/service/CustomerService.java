package com.example.HotelManagementProject.service;

import com.example.HotelManagementProject.model.Booking;
import com.example.HotelManagementProject.model.Customer;
import com.example.HotelManagementProject.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

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

    public boolean checkName(Customer currentCustomer) {
        String name = currentCustomer.getName();
        long number = currentCustomer.getPhoneNumber();
        String email = currentCustomer.getEmail();


        List<Customer> customers = getCustomers();
        for (Customer customer : customers) {
            if (customer.getName().equalsIgnoreCase(name) && customer.getPhoneNumber() == number && customer.getEmail().equalsIgnoreCase(email) )
            {
                return true; // Name already exists
            }
        }
        return false; // Name doesn't exist
    }

    public Optional<Customer> getCustomerById(long id)
    {
        return customerRepository.findById(id);
    }




}


