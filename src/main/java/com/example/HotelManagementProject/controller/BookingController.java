package com.example.HotelManagementProject.controller;

import com.example.HotelManagementProject.model.Booking;
import com.example.HotelManagementProject.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/bookings")
public class BookingController {
    private final BookingService bookingService;

    @Autowired
    public BookingController(BookingService bookingService)
    {
        this.bookingService = bookingService;
    }
    @GetMapping
    public List<Booking>getBookings()
    {
        return bookingService.getBookings();
    }


}
