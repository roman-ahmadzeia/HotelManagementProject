package com.example.HotelManagementProject.controller;

import com.example.HotelManagementProject.model.Customer;
import com.example.HotelManagementProject.service.BookingService;
import com.example.HotelManagementProject.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Controller
public class CustomerController {
    private final CustomerService customerService;
    private final BookingService bookingService;
    @Autowired
    public CustomerController(CustomerService customerService, BookingService bookingService)
    {
        this.customerService = customerService;
        this.bookingService = bookingService;
    }
    @GetMapping("/customers")
    public String getCustomerPage(Model model)
    {
        model.addAttribute("listCustomers", customerService.getCustomers());
        model.addAttribute("newCustomer", new Customer());
        return "customers";
    }

    @PostMapping("/addCustomer")
    public String addCustomer(@ModelAttribute("newCustomer") Customer newCustomer) {
        customerService.addCustomer(newCustomer);
        return "redirect:/customers";
    }

    @GetMapping("/")
    public String getHomePage(Model model)
    {
        long bookingCount = bookingService.getBookings().size();
        double totalBookingPrice = bookingService.getTotalBookingsPrice();
        double occupancyRate = bookingService.getOccupancyRate();
        model.addAttribute("bookingCount", bookingCount);
        model.addAttribute("revenue", totalBookingPrice);
        model.addAttribute("occupancyRate", occupancyRate);

        return "dashboard.html";
    }
//    public List<Customer> getCustomers()
//    {
//        return customerService.getCustomers();
//    }

}
