package com.example.HotelManagementProject;

import com.example.HotelManagementProject.model.Room;
import com.example.HotelManagementProject.repository.RoomRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class HotelManagementProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(HotelManagementProjectApplication.class, args);
	}

	@Bean
	public CommandLineRunner loadData(RoomRepository roomRepository) {
		return (args) -> {
			Room[] rooms = {
					new Room(101, "Standard", 100),
					new Room(102, "Standard", 100),
					new Room(201, "Suite", 500),
					new Room(202, "Suite", 500),
					new Room(901, "Deluxe", 1500),
					new Room(1001, "Deluxe", 1500)
			};

			for (Room room : rooms) {
				roomRepository.save(room);
			}
		};
	}





}
