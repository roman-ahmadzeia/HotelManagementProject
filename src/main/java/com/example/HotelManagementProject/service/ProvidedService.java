package com.example.HotelManagementProject.service;

import com.example.HotelManagementProject.model.Booking;
import com.example.HotelManagementProject.model.Room;
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

    public void addService(com.example.HotelManagementProject.model.ProvidedService service)
    {
        providedServiceRepository.save(service);
    }


    public double getTotalPrice() {
        List<com.example.HotelManagementProject.model.ProvidedService> services = providedServiceRepository.findAll();
        double totalPrice = 0;
        for (com.example.HotelManagementProject.model.ProvidedService service : services) {
            totalPrice += service.getPrice();
        }
        return totalPrice;
    }

}
