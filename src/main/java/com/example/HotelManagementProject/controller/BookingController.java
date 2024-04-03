package com.example.HotelManagementProject.controller;

import com.example.HotelManagementProject.model.Booking;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/booking")
public class BookingController {

    @GetMapping
    public List<Booking>getAllBookings()
    {
        return List.of(new Booking(
                1L, 001L, "April 2 2024", "April 4 2024")
        );
    }
}
