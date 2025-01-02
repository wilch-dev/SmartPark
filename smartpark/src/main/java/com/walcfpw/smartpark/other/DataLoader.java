package com.walcfpw.smartpark.other;

import com.walcfpw.smartpark.data.enums.VehicleType;
import com.walcfpw.smartpark.data.repository.ParkingLotRepository;
import com.walcfpw.smartpark.data.repository.VehicleRepository;
import com.walcfpw.smartpark.data.repository.entities.ParkingLotEntity;
import com.walcfpw.smartpark.data.repository.entities.VehicleEntity;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class DataLoader implements CommandLineRunner {

    private final ParkingLotRepository parkingLotRepository;
    private final VehicleRepository vehicleRepository;


    @Override
    public void run(String... args) throws Exception {
        // Load initial data into the database
        loadSampleParkingLotDataToDb();
        loadSampleVehicleDataToDb();
    }

    public void loadSampleParkingLotDataToDb() {
        ParkingLotEntity parkingLot1 = ParkingLotEntity.builder()
                .lotId("one-parkade")
                .location("7th Street")
                .totalCapacity(10)
                .currentlyOccupiedSlots(0)
                .costPerMinute(10.0)
                .build();
        ParkingLotEntity parkingLot2 = ParkingLotEntity.builder()
                .lotId("two-parkade")
                .location("8th Street")
                .totalCapacity(20)
                .currentlyOccupiedSlots(0)
                .costPerMinute(20.2)
                .build();
        ParkingLotEntity parkingLot3 = ParkingLotEntity.builder()
                .lotId("three-parkade")
                .location("9th Street")
                .totalCapacity(30)
                .currentlyOccupiedSlots(0)
                .costPerMinute(30.3)
                .build();
        parkingLotRepository.save(parkingLot1);
        parkingLotRepository.save(parkingLot2);
        parkingLotRepository.save(parkingLot3);
    }

    public void loadSampleVehicleDataToDb() {
        VehicleEntity vehicle1 = VehicleEntity.builder()
                .licensePlate("AAA-123")
                .vehicleType(VehicleType.MOTORCYCLE)
                .ownerName("John Doe")
                .build();
        VehicleEntity vehicle2 = VehicleEntity.builder()
                .licensePlate("BBB-234")
                .vehicleType(VehicleType.CAR)
                .ownerName("Jill Hampton")
                .build();
        VehicleEntity vehicle3 = VehicleEntity.builder()
                .licensePlate("CCC-456")
                .vehicleType(VehicleType.TRUCK)
                .ownerName("Alex Cruz")
                .build();
        vehicleRepository.save(vehicle1);
        vehicleRepository.save(vehicle2);
        vehicleRepository.save(vehicle3);
    }

}