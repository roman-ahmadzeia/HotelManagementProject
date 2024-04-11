package com.example.HotelManagementProject.controller;

import com.example.HotelManagementProject.model.Room;
import com.example.HotelManagementProject.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class RoomController {
    private final RoomService roomService;

    @Autowired
    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @GetMapping("/rooms")
    public String getRoomPage(Model model) {
        model.addAttribute("listRooms", roomService.getRooms());
        model.addAttribute("newRoom", new Room());
        return "rooms";
    }

    @PostMapping("/addRoom")
    public String addRoom(@ModelAttribute("newRoom") Room newRoom) {
        roomService.addRoom(newRoom);
        return "redirect:/rooms";
    }

    @PostMapping("/deleteRoom")
    public String deleteRoom(@ModelAttribute("deleteRoom") Room newRoom)
    {
        roomService.deleteRoom(newRoom);
        return "redirect:/rooms";
    }

}
