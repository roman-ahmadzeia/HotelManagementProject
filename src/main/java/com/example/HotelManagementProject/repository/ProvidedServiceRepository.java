package com.example.HotelManagementProject.repository;

import com.example.HotelManagementProject.model.ProvidedService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProvidedServiceRepository extends JpaRepository<ProvidedService, Long> {
}
