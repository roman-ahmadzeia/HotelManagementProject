package com.example.HotelManagementProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.HotelManagementProject.model.Room;

// THIS IS WHERE YOU DO YOUR ORM AND QUERYING
public interface RoomRepository extends JpaRepository<Room, Long> {
}
