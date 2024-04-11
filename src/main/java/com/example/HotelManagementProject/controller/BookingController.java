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

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
                             @RequestParam(value = "services", required = false) List<String> services,
                             @RequestParam("startDate") String startDateStr,
                             @RequestParam("endDate") String endDateStr,
                             Model model){

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate startDate = LocalDate.parse(startDateStr, formatter);
        LocalDate endDate = LocalDate.parse(endDateStr, formatter);

        newBooking.setStartDate(startDate);
        newBooking.setEndDate(endDate);

        newBooking.setCustomerid(customerId);
        newBooking.setRoomid(roomId);

        // Save the booking to get the booking ID
        if (!bookingService.availabilityCheck(newBooking)) {
            System.out.println("not available");
            model.addAttribute("error", "Room not available for selected dates.");
            return "bookings"; // Return to the bookings page with an error message
        }
        Booking savedBooking = bookingService.addBooking(newBooking);
        int UUID = 0;
        double service_cost = 0;
        // Save the selected services associated with the booking ID
        if (services != null && !services.isEmpty()) {
            for (int i = 0; i < services.size(); i++) {
                ProvidedService providedService = new ProvidedService();
                UUID = UUID + 1;
                providedService.setId(savedBooking.getId() + "_" + UUID); // Use a unique ID
                providedService.setServiceName(services.get(i));
                if ("Breakfast".equals(services.get(i))) {
                    providedService.setPrice(20);
                    service_cost = service_cost + 20;
                } else if ("Lunch".equals(services.get(i))) {
                    providedService.setPrice(35);
                    service_cost = service_cost + 35;

                } else if ("VIP Lounge".equals(services.get(i))) {
                    providedService.setPrice(100);
                    service_cost = service_cost + 100;

                } else if ("SPA".equals(services.get(i))) {
                    providedService.setPrice(80);
                    service_cost = service_cost + 80;

                }
                providedService_service.addService(providedService);
            }
        }
        model.addAttribute("startDate", savedBooking.getStartDate());
        model.addAttribute("endDate", savedBooking.getEndDate());

        model.addAttribute("customerName", customerService.getCustomerById(customerId).get().getName());
        model.addAttribute("roomNumber", roomService.getRoomById(roomId).getRoomNumber());
        model.addAttribute("totalCost", bookingService.roomPriceTotal(savedBooking) + service_cost);

        return "invoice";

    }

}
