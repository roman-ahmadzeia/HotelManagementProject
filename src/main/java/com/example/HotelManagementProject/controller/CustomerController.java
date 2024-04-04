package com.example.HotelManagementProject.controller;

import com.example.HotelManagementProject.model.Customer;
import com.example.HotelManagementProject.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Controller
public class CustomerController {
    private final CustomerService customerService;
    @Autowired
    public CustomerController(CustomerService customerService)
    {
        this.customerService = customerService;
    }
    @GetMapping("/")
    public String getCustomerPage(Model model)
    {
        model.addAttribute("listCustomers", customerService.getCustomers());
        model.addAttribute("newCustomer", new Customer());
        return "customers";
    }

    @PostMapping("/addCustomer")
    public String addCustomer(@ModelAttribute("newCustomer") Customer newCustomer) {
        customerService.addCustomer(newCustomer);
        return "redirect:/";
    }






//    public List<Customer> getCustomers()
//    {
//        return customerService.getCustomers();
//    }

}
