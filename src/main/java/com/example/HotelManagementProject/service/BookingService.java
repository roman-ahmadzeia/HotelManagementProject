package com.example.HotelManagementProject.service;

import com.example.HotelManagementProject.model.Booking;
import com.example.HotelManagementProject.model.Customer;
import com.example.HotelManagementProject.model.Room;
import com.example.HotelManagementProject.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingService {
    private final BookingRepository bookingRepository;

    private final RoomService roomService;

    @Autowired
    public BookingService(BookingRepository bookingRepository, RoomService roomService)
    {
        this.bookingRepository = bookingRepository;
        this.roomService = roomService;
    }


    public List<Booking> getBookings()
    {
        return bookingRepository.findAll();
    }

    public void addBooking(Booking newBooking)
    {
        bookingRepository.save(newBooking);
    }

    public double getTotalBookingsPrice() {
        List<Booking> bookings = bookingRepository.findAll();
        return bookings.stream()
                .mapToDouble(booking -> roomService.getRoomById(booking.getRoomid()).getPrice())
                .sum();
    }

    public double getOccupancyRate() {
        int bookings = bookingRepository.findAll().size();
        int rooms = roomService.getRooms().size();

        if (rooms == 0) {
            return 0.0;
        }

        return (double) bookings / rooms * 100;
    }


}
