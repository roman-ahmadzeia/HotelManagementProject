package com.example.HotelManagementProject.controller;

import com.example.HotelManagementProject.model.Booking;
import com.example.HotelManagementProject.model.ProvidedService;
import com.example.HotelManagementProject.service.BookingService;
import com.example.HotelManagementProject.model.Customer;
import com.example.HotelManagementProject.service.CustomerService;
import com.example.HotelManagementProject.model.Room;
import com.example.HotelManagementProject.service.RoomService;
import org.aspectj.apache.bcel.classfile.Module;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Controller
public class BookingController {
    private final BookingService bookingService;
    private final CustomerService customerService;
    private final RoomService roomService;
    private final com.example.HotelManagementProject.service.ProvidedService providedService_service;

    @Autowired
    public BookingController(BookingService bookingService, CustomerService customerService, RoomService roomService,  com.example.HotelManagementProject.service.ProvidedService providedService_service) {
        this.bookingService = bookingService;
        this.customerService = customerService;
        this.roomService = roomService;
        this.providedService_service = providedService_service;

    }

    @GetMapping("/bookings")
    public String getBookingPage(Model model) {
        List<Customer> customers = customerService.getCustomers();
        List<Room> rooms = roomService.getRooms();
        long bookingCount = bookingService.getBookings().size();
        model.addAttribute("customers", customers);
        model.addAttribute("rooms", rooms);
        model.addAttribute("newBooking", new Booking());
        model.addAttribute("bookingCount", bookingCount);
        return "bookings";
    }

    @PostMapping("/addBooking")
    public String addBooking(@ModelAttribute("newBooking") Booking newBooking,
                             @RequestParam("customerId") Long customerId,
                             @RequestParam("roomId") Long roomId,
                             @RequestParam(value = "services", required = false) List<String> services) {
        newBooking.setCustomerid(customerId);
        newBooking.setRoomid(roomId);
        // Save the booking to get the booking ID
        Booking savedBooking = bookingService.addBooking(newBooking);
        for (String i: services)
        {
            System.out.println(i);
        }

        int i = 0;
        // Save the selected services associated with the booking ID
        if (services != null && !services.isEmpty()) {
            for (String serviceName : services) {
                ProvidedService providedService = new ProvidedService();
                i = i + 1;
                providedService.setId(savedBooking.getId() + i); // Use a unique ID
                providedService.setServiceName(serviceName);
                providedService.setPrice(1);
                providedService_service.addService(providedService);
            }
        }

        return "redirect:/bookings";
    }






}
