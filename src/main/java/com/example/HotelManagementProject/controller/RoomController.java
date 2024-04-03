package com.example.HotelManagementProject.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.HotelManagementProject.service.RoomService;
import com.example.HotelManagementProject.model.Room;
import java.util.*;
@RestController
@RequestMapping(path="/api/rooms")
public class RoomController {

    private final RoomService roomSerivce;

    public RoomController(RoomService roomService)
    {
        this.roomSerivce = roomService;
    }

    @GetMapping
    public List<Room>getRooms()
    {
        return roomSerivce.getRooms();
    }
}

