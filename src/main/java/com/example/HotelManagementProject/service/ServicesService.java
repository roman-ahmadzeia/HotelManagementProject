package com.example.HotelManagementProject.service;

import com.example.HotelManagementProject.model.Services;
import com.example.HotelManagementProject.repository.ServicesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicesService {

    private final ServicesRepository servicesRepository;

    @Autowired
    public ServicesService(ServicesRepository servicesRepository) {
        this.servicesRepository = servicesRepository;
    }

    public List<Services> getServices() {
        return servicesRepository.findAll();
    }
}
