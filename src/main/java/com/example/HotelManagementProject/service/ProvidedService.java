package com.example.HotelManagementProject.service;

import com.example.HotelManagementProject.repository.ProvidedServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProvidedService {

    private final ProvidedServiceRepository providedServiceRepository;

    @Autowired
    public ProvidedService(ProvidedServiceRepository providedServiceRepository) {
        this.providedServiceRepository = providedServiceRepository;
    }

    public List<com.example.HotelManagementProject.model.ProvidedService> getServices() {
        return providedServiceRepository.findAll();
    }
}
