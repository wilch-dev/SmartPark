package com.walcfpw.smartpark.service.impl;


import com.walcfpw.smartpark.data.dto.ParkingLotDto;
import com.walcfpw.smartpark.data.repository.ParkingLotRepository;
import com.walcfpw.smartpark.data.repository.entities.ParkingLotEntity;
import com.walcfpw.smartpark.service.ParkingLotService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
@Slf4j
public class ParkingLotServiceImpl implements ParkingLotService {

    private final ParkingLotRepository parkingLotRepository;

    @Override
    public ParkingLotDto registerParkingLot(ParkingLotDto parkingLotDto) throws Exception {
        Optional<ParkingLotEntity> parkingLotInDb = parkingLotRepository.findById(parkingLotDto.getLotId());

        // Check if in DB
        if(parkingLotInDb.isPresent()){
            throw new Exception("Inputted lotId already exists.");
        }
        // Check for bad input - this throws error
        validateParkingLotRegistration(parkingLotDto);

        // Make sure occupied slots is 0. Won't be validating input for this because of time. But in reality, I should.
        ParkingLotEntity entityToSave = parkingLotDto.toEntity();
        entityToSave.setCurrentlyOccupiedSlots(0);

        // save entity and return DTO
        return parkingLotRepository.save(entityToSave).toDto();
    }

    @Override
    public ParkingLotDto findParkingLotById(ParkingLotDto parkingLotDto) throws Exception {
        validateParkingLotId(parkingLotDto);
        Optional<ParkingLotEntity> parkingLotEntity = parkingLotRepository.findById(parkingLotDto.getLotId());
        if (parkingLotEntity.isEmpty()) {
            throw new Exception(String.format("Parking lot with ID: %s - not found.", parkingLotDto.getLotId()));
        }
        return parkingLotEntity.get().toDto();
    }

    @Override
    public List<ParkingLotDto> getAllParkingLots() throws Exception {
        List <ParkingLotEntity> parkingLotEntities = parkingLotRepository.findAll();
        if (parkingLotEntities.isEmpty()) {
            throw new Exception("No parking lots found in db.");
        }
        return parkingLotEntities.parallelStream().map(parkingLotEntity -> parkingLotEntity.toDto()).toList();
    }

    private void validateParkingLotRegistration(ParkingLotDto parkingLotDto) throws Exception {
        validateParkingLotId(parkingLotDto);
        if(parkingLotDto.getTotalCapacity() <= 0) {
            throw new Exception("Inputted totalCapacity is not a positive integer.");
        }
        if(parkingLotDto.getCostPerMinute() <= 0) {
            throw new Exception("Inputted costPerMinute is not a positive number.");
        }
    }

    private void validateParkingLotId(ParkingLotDto parkingLotDto) throws Exception {
        if(parkingLotDto.getLotId().length() > 50){
            throw new Exception("Inputted lotId too long. Max 50 characters.");
        }
        if(parkingLotDto.getLotId().isEmpty() || parkingLotDto.getLotId().isBlank()){
            throw new Exception("Inputted lotId is blank.");
        }
    }

}
