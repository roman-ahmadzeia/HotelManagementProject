package com.example.HotelManagementProject.service;
import com.example.HotelManagementProject.model.Room;
import com.example.HotelManagementProject.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import com.example.HotelManagementProject.repository.RoomRepository;

import java.util.*;
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



}
