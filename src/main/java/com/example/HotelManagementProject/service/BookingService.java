package com.example.HotelManagementProject.service;

import com.example.HotelManagementProject.model.Booking;
import com.example.HotelManagementProject.model.Room;
import com.example.HotelManagementProject.repository.BookingRepository;
import com.example.HotelManagementProject.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.temporal.ChronoUnit;
import java.time.LocalDate;
import java.util.List;

@Service
public class BookingService {
    private final BookingRepository bookingRepository;

    private final RoomService roomService;

    private final ProvidedService providedService;

    @Autowired
    public BookingService(BookingRepository bookingRepository, RoomService roomService, ProvidedService providedService)
    {
        this.bookingRepository = bookingRepository;
        this.roomService = roomService;
        this.providedService = providedService;
    }


    public List<Booking> getBookings()
    {
        return bookingRepository.findAll();
    }

    public Booking addBooking(Booking newBooking)
    {
        bookingRepository.save(newBooking);
        return newBooking;
    }

    public double roomPriceTotal(Booking booking)
    {
        LocalDate start_date = booking.getStartDate();
        LocalDate end_date = booking.getEndDate();
        long differenceInDays = ChronoUnit.DAYS.between(start_date, end_date);
        double room_cost = roomService.getRoomById(booking.getRoomid()).getPrice() * differenceInDays;
        System.out.println("room: " + roomService.getRoomById(booking.getId()).getPrice());

        return room_cost;
    }

    public double totalRevenue()
    {
        double service_cost = providedService.getTotalPrice(); // sum of all prices in services database
        double room_cost = 0; // total sum of each bookings room price * days reserverd
        List<Booking> bookings = bookingRepository.findAll();
        for (Booking i: bookings)
        {
            room_cost += roomPriceTotal(i);
        }

        return service_cost + room_cost;

    }


    public double getOccupancyRate() {
        int bookings = bookingRepository.findAll().size();
        int rooms = roomService.getRooms().size();

        if (rooms == 0) {
            return 0.0;
        }

        double occupancyRate = (double) bookings / rooms * 100;
        return Double.parseDouble(String.format("%.1f", occupancyRate));
    }

    public boolean availabilityCheck(Booking currentBooking) {
        LocalDate start_date = currentBooking.getStartDate();
        LocalDate end_date = currentBooking.getEndDate();
        long room_id = currentBooking.getRoomid();

        // Get all bookings for the room
        List<Booking> roomBookings = bookingRepository.findByRoomId(room_id);

        // Check for overlapping bookings
        for (Booking booking : roomBookings) {
            LocalDate booking_start = booking.getStartDate();
            LocalDate booking_end = booking.getEndDate();

            if (start_date.isBefore(booking_end) && end_date.isAfter(booking_start)) {
                // There is an overlapping booking
                return false;
            }
        }

        // No overlapping bookings found, room is available
        return true;
    }




}
