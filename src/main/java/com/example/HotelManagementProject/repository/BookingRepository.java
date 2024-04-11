package com.example.HotelManagementProject.repository;

import com.example.HotelManagementProject.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

// THIS IS WHERE YOU DO YOUR ORM AND QUERYING

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {
    @Query("SELECT b FROM Booking b WHERE b.roomid = :room_id")
    List<Booking> findByRoomId(@Param("room_id") long room_id);


}
