package com.walcfpw.smartpark.service.impl;

import com.walcfpw.smartpark.data.dto.VehicleDto;
import com.walcfpw.smartpark.data.enums.VehicleType;
import com.walcfpw.smartpark.data.repository.VehicleRepository;
import com.walcfpw.smartpark.data.repository.entities.ParkingLotEntity;
import com.walcfpw.smartpark.data.repository.entities.VehicleEntity;
import com.walcfpw.smartpark.service.VehicleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
@Slf4j
public class VehicleServiceImpl implements VehicleService {

    private final VehicleRepository vehicleRepository;

    @Override
    public VehicleDto registerVehicle(VehicleDto vehicleDto) throws Exception {
        Optional<VehicleEntity> vehicleInDb = vehicleRepository.findById(vehicleDto.getLicensePlate());

        // Check if in DB
        if(vehicleInDb.isPresent()){
            throw new Exception("Inputted licensePlate is already registered.");
        }
        // Check for bad input - this throws error
        validateVehicleDto(vehicleDto);


        // Make sure occupied slots is 0. Won't be validating input for this because of time. But in reality, I should.
        VehicleEntity entityToSave = vehicleDto.toEntity();

        // save entity and return DTO
        return vehicleRepository.save(entityToSave).toDto();
    }

    @Override
    public VehicleDto findRegisteredVehicleByLicensePlate(VehicleDto vehicleDto) throws Exception {
        validateLicensePlate(vehicleDto.getLicensePlate());

        Optional<VehicleEntity> vehicleEntity = vehicleRepository.findById(vehicleDto.getLicensePlate());
        if (vehicleEntity.isEmpty()) {
            throw new Exception(String.format("Vehicle with license plate: %s - not found.", vehicleDto.getLicensePlate()));
        }

        return vehicleEntity.get().toDto();
    }

    @Override
    public List<VehicleDto> getAllRegisteredVehicles() throws Exception {
        List <VehicleEntity> vehicleEntities = vehicleRepository.findAll();
        if (vehicleEntities.isEmpty()) {
            throw new Exception("No vehicles found in db.");
        }
        return vehicleEntities.parallelStream().map(entity -> entity.toDto()).toList();
    }



    private void validateLicensePlate(String licensePlate) throws Exception {
        // alphanumeric and - regex
        if(!licensePlate.matches("^([A-Za-z0-9-])*$")){
            throw new Exception("Invalid license plate. Alphanumeric and \"-\" characters only.");
        }
    }

    private void validateName(String name) throws Exception {
        // alphanumeric and space regex
        if(!name.matches("^([A-Za-z0-9 ])*$")){
            throw new Exception("Invalid name. Alphanumeric and space characters only.");
        }
    }

//    private void validateVehicleType(String type) throws Exception {
//        // alphanumeric and space regex
//        if(!type.equalsIgnoreCase(VehicleType.CAR.toString()) ||
//                !type.equalsIgnoreCase(VehicleType.TRUCK.toString()) ||
//                !type.equalsIgnoreCase(VehicleType.MOTORCYCLE.toString())){
//            throw new Exception("Invalid vehicle type.");
//        }
//    }

    private void validateVehicleDto(VehicleDto vehicleDto) throws Exception {
        validateLicensePlate(vehicleDto.getLicensePlate());
        validateName(vehicleDto.getOwnerName());
//        validateVehicleType(vehicleDto.getVehicleType().toString());
    }
}
