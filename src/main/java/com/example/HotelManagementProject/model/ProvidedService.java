package com.example.HotelManagementProject.model;

import jakarta.persistence.Entity;
import jakarta.persistence.*;

@Entity
@Table(name = "Services")
public class ProvidedService {
    @Id
    private String id; // should be the booking id
    private String serviceName;
    private double price;

    public ProvidedService() {
    }

    public ProvidedService(String id, String serviceName, double price) {
        this.id = id;
        this.serviceName = serviceName;
        this.price = price;
    }

    public ProvidedService(String serviceName, double price) {
        this.serviceName = serviceName;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Service{" +
                "id=" + id +
                ", serviceName='" + serviceName + '\'' +
                ", price=" + price +
                '}';
    }
}