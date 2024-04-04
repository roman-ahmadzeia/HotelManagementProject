package com.example.HotelManagementProject.service;

import com.example.HotelManagementProject.model.Booking;
import com.example.HotelManagementProject.model.Customer;
import com.example.HotelManagementProject.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingService {
    private final BookingRepository bookingRepository;

    @Autowired
    public BookingService(BookingRepository bookingRepository)
    {
        this.bookingRepository = bookingRepository;
    }

    public List<Booking> getBookings()
    {
        return bookingRepository.findAll();
    }

    public void addBooking(Booking newBooking)
    {
        bookingRepository.save(newBooking);
    }

}
