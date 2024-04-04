package com.example.HotelManagementProject.controller;

import com.example.HotelManagementProject.model.Booking;
import com.example.HotelManagementProject.service.BookingService;
import com.example.HotelManagementProject.model.Customer;
import com.example.HotelManagementProject.service.CustomerService;
import com.example.HotelManagementProject.model.Room;
import com.example.HotelManagementProject.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class BookingController {
    private final BookingService bookingService;
    private final CustomerService customerService;
    private final RoomService roomService;

    @Autowired
    public BookingController(BookingService bookingService, CustomerService customerService, RoomService roomService) {
        this.bookingService = bookingService;
        this.customerService = customerService;
        this.roomService = roomService;
    }

    @GetMapping("/bookings")
    public String getBookingPage(Model model) {
        List<Customer> customers = customerService.getCustomers();
        List<Room> rooms = roomService.getRooms();
        model.addAttribute("customers", customers);
        model.addAttribute("rooms", rooms);
        model.addAttribute("newBooking", new Booking());
        return "bookings";
    }

    @PostMapping("/addBooking")
    public String addBooking(@ModelAttribute("newBooking") Booking newBooking,
                             @RequestParam("customerId") Long customerid,
                             @RequestParam("roomId") Long roomid) {
        newBooking.setCustomerid(customerid);
        newBooking.setRoomid(roomid);
        bookingService.addBooking(newBooking);
        return "redirect:/bookings";
    }
    
}
