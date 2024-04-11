package com.example.HotelManagementProject.service;
import com.example.HotelManagementProject.model.Room;
import com.example.HotelManagementProject.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import com.example.HotelManagementProject.repository.RoomRepository;

import java.util.List;
@Service
public class RoomService {
    private final RoomRepository roomRepository;

    @Autowired
    public RoomService(RoomRepository roomRepository)
    {
        this.roomRepository = roomRepository;
    }

    public List<Room> getRooms()
    {
        return roomRepository.findAll();
    }

    public Room getRoomById(Long roomId) {
        return roomRepository.findById(roomId)
                .orElseThrow(() -> new RuntimeException("Room not found"));
    }


    public void addRoom(Room newRoom) {
        roomRepository.save(newRoom);
    }

    public void deleteRoom(Room newRoom)
    {
        roomRepository.delete(newRoom);
    }
}
