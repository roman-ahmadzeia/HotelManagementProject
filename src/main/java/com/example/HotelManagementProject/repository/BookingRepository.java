package com.example.HotelManagementProject.repository;

import com.example.HotelManagementProject.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// THIS IS WHERE YOU DO YOUR ORM AND QUERYING

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {


}
