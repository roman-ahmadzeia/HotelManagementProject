package com.example.HotelManagementProject.controller;

import com.example.HotelManagementProject.model.Services;
import com.example.HotelManagementProject.service.ServicesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/services")
public class ServicesController {
    private final ServicesService service;

    @Autowired
    public ServicesController(ServicesService service) {
        this.service = service;
    }

    @GetMapping
    public List<Services> getServices() {
        return service.getServices();
    }
}
