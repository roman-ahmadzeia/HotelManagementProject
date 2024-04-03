package com.example.HotelManagementProject.service;

import com.example.HotelManagementProject.model.Booking;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Service
public class BookingService {

    public List<Booking> getBookings()
    {
        return List.of(new Booking(
                1L, 001L, "April 2 2024", "April 4 2024")
        );
    }

}
