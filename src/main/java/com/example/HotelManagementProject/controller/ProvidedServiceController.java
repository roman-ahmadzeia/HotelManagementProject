package com.example.HotelManagementProject.controller;

import com.example.HotelManagementProject.model.ProvidedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/services")
public class ProvidedServiceController {
    private final com.example.HotelManagementProject.service.ProvidedService service;

    @Autowired
    public ProvidedServiceController(com.example.HotelManagementProject.service.ProvidedService service) {
        this.service = service;
    }

    @GetMapping
    public List<ProvidedService> getServices() {
        return service.getServices();
    }
}
