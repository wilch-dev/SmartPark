package com.walcfpw.smartpark.service.impl;



import com.walcfpw.smartpark.data.dto.ParkingLotDto;
import com.walcfpw.smartpark.data.mapper.ParkingLotMapper;
import com.walcfpw.smartpark.data.repository.entities.ParkingLotEntity;
import com.walcfpw.smartpark.errors.CostPerMinuteException;
import com.walcfpw.smartpark.errors.ParkingLotIdExistsException;
import com.walcfpw.smartpark.errors.ParkingLotIdTooLongException;
import com.walcfpw.smartpark.errors.TotalCapacityException;
import com.walcfpw.smartpark.data.repository.ParkingLotRepository;
import com.walcfpw.smartpark.service.ParkingLotService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@RequiredArgsConstructor
@Service
@Slf4j
public class ParkingLotServiceImpl implements ParkingLotService {

    private final ParkingLotRepository parkingLotRepository;

    @Override
    public ParkingLotDto registerParkingLot(ParkingLotDto parkingLotDto) throws ParkingLotIdExistsException, TotalCapacityException, CostPerMinuteException, ParkingLotIdTooLongException {
        Optional<ParkingLotEntity> parkingLotInDb = parkingLotRepository.findById(parkingLotDto.getLotId());

        // Check for bad input
        if(parkingLotInDb.isPresent()){
            throw new ParkingLotIdExistsException("Inputted lotId already exists.");
        }
        if(parkingLotDto.getLotId().length() > 50){
            throw new ParkingLotIdTooLongException("Inputted lotId too long. Max 50 characters.");
        }
        if(parkingLotDto.getTotalCapacity() <= 0) {
            throw new TotalCapacityException("Inputted totalCapacity is not a positive integer.");
        }
        if(parkingLotDto.getCostPerMinute() <= 0) {
            throw new CostPerMinuteException("Inputted costPerMinute is not a positive number.");
        }

        // Make sure occupied slots is 0. Won't be validating input for this because of time. But in reality, I should.
        ParkingLotEntity entityToSave = parkingLotDto.toEntity();
        entityToSave.setCurrentlyOccupiedSlots(0);

        // save entity and return DTO
        return parkingLotRepository.save(entityToSave).toDto();
    }
}
