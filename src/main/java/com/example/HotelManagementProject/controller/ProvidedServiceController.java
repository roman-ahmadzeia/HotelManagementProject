package com.example.HotelManagementProject.controller;

import com.example.HotelManagementProject.model.ProvidedService;
import com.example.HotelManagementProject.model.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import java.util.List;

@Controller
public class ProvidedServiceController {
    private final com.example.HotelManagementProject.service.ProvidedService service;

    @Autowired
    public ProvidedServiceController(com.example.HotelManagementProject.service.ProvidedService service) {
        this.service = service;
    }

    @GetMapping("/services")
    public String getServicesPage(Model model) {
        List<ProvidedService> services = service.getServices();
        model.addAttribute("services", services);
        return "services";
    }


    @PostMapping("/addService")
    public void addService(@ModelAttribute("newService") ProvidedService serv)
    {
        service.addService(serv);
    }
}
