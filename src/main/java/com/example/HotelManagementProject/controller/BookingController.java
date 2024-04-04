package com.example.HotelManagementProject.controller;

import com.example.HotelManagementProject.model.Booking;
import com.example.HotelManagementProject.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class BookingController {
    private final BookingService bookingService;

    @Autowired
    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @GetMapping("/bookings")
    public String getBookingPage(Model model) {
        List<Booking> bookings = bookingService.getBookings();
        model.addAttribute("bookings", bookings);
        model.addAttribute("newBooking", new Booking());
        return "bookings";
    }

    @PostMapping("/addBooking")
    public String addBooking(@ModelAttribute("newBooking") Booking newBooking) {
        bookingService.addBooking(newBooking);
        return "redirect:/bookings";
    }
}
