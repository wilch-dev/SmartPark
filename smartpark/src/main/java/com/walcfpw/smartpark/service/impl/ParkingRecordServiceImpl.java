package com.walcfpw.smartpark.service.impl;

import com.walcfpw.smartpark.data.dto.ParkingLotDto;
import com.walcfpw.smartpark.data.dto.ParkingRecordDto;
import com.walcfpw.smartpark.data.dto.VehicleDto;
import com.walcfpw.smartpark.data.repository.ParkingRecordRepository;
import com.walcfpw.smartpark.data.repository.entities.ParkingLotEntity;
import com.walcfpw.smartpark.data.repository.entities.ParkingRecordEntity;
import com.walcfpw.smartpark.service.ParkingLotService;
import com.walcfpw.smartpark.service.ParkingRecordService;
import com.walcfpw.smartpark.service.VehicleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RequiredArgsConstructor
@Service
@Slf4j
public class ParkingRecordServiceImpl implements ParkingRecordService {

    private final ParkingRecordRepository parkingRecordRepository;
    private final ParkingLotService parkingLotService;
    private final VehicleService vehicleService;

    @Override
    public ParkingRecordDto timeIn(ParkingRecordDto parkingRecordDto) throws Exception {
        VehicleDto vehicleInDb = vehicleService.findRegisteredVehicleByLicensePlate(VehicleDto.builder().licensePlate(parkingRecordDto.getLicensePlate()).build());

        // find in repo
        // check if vehicle license is parked and is active based on time out
        // check if car is never parked as well
        Optional <ParkingRecordEntity> parkingRecordEntityInDb =
                parkingRecordRepository.findLatestRecordOfLicensePlateBasedOnTimeIn(vehicleInDb.getLicensePlate());
        if (parkingRecordEntityInDb.isPresent() && Objects.isNull(parkingRecordEntityInDb.get().getTimeOut())){
            throw new Exception("Currently Parked.");
        }

        ParkingLotDto parkingLotInDb = parkingLotService.findParkingLotById(ParkingLotDto.builder().lotId(parkingRecordDto.getLotId()).build());
        //checker here of parkingLotOccupancy
        parkingLotInDb = parkingLotService.increaseOccupiedSlots(parkingLotInDb);

        ParkingRecordEntity parkingRecordEntityToSave = ParkingRecordEntity.builder()
                .parkingLotEntity(parkingLotInDb.toEntity())
                .vehicleEntity(vehicleInDb.toEntity())
                .timeIn(LocalDateTime.now())
                .build();
        return parkingRecordRepository.save(parkingRecordEntityToSave).toDto();
    }

    @Override
    public ParkingRecordDto timeOut(ParkingRecordDto parkingRecordDto) throws Exception {
        VehicleDto vehicleInDb = vehicleService.findRegisteredVehicleByLicensePlate(VehicleDto.builder().licensePlate(parkingRecordDto.getLicensePlate()).build());
        ParkingLotDto parkingLotInDb = parkingLotService.findParkingLotById(ParkingLotDto.builder().lotId(parkingRecordDto.getLotId()).build());

        Optional <ParkingRecordEntity> parkingRecordEntityInDb =
                parkingRecordRepository.findLatestRecordOfLicensePlateBasedOnTimeIn(vehicleInDb.getLicensePlate());

        // if not in db
        if (parkingRecordEntityInDb.isEmpty()){
            throw new Exception(String.format("Vehicle with license plate %s is not parked", parkingRecordDto.getLicensePlate()));
        }
        // Since we already check empty, then it's already there. If record exists but last record is a timeOut, meaning car left.
        if (Objects.nonNull(parkingRecordEntityInDb.get().getTimeOut())){
            throw new Exception(String.format("Vehicle with license plate %s is not parked", parkingRecordDto.getLicensePlate()));
        }
        // if lotId and current db record doesn't match
        if (!parkingRecordEntityInDb.get().getParkingLotEntity().getLotId().equals(parkingRecordDto.getLotId())){
            throw new Exception(String.format("Vehicle with license plate %s is not parked in inputted parking lot", parkingRecordDto.getLicensePlate()));
        }

        LocalDateTime timeInOfRecord = parkingRecordEntityInDb.get().getTimeIn();

        Long secondsParked = timeInOfRecord.until(LocalDateTime.now(), ChronoUnit.SECONDS);
        Integer minutesParked = convertSecondsToMinutesRoundUp(secondsParked);

        parkingLotInDb = parkingLotService.decreaseOccupiedSlots(parkingLotInDb);

        ParkingRecordEntity parkingRecordEntityToSave = ParkingRecordEntity.builder()
                .id(parkingRecordEntityInDb.get().getId())
                .parkingLotEntity(parkingLotInDb.toEntity())
                .vehicleEntity(vehicleInDb.toEntity())
                .timeIn(parkingRecordEntityInDb.get().getTimeIn())
                .timeOut(LocalDateTime.now())
                .amountCharged(minutesParked * parkingLotInDb.getCostPerMinute())
                .build();
        return parkingRecordRepository.save(parkingRecordEntityToSave).toDto();

    }

    @Override
    public List<ParkingRecordDto> getAllParkingRecords() throws Exception {
        List <ParkingRecordEntity> parkingRecordEntities = parkingRecordRepository.findAll();
        if (parkingRecordEntities.isEmpty()) {
            throw new Exception("No parking records found in db.");
        }
        return parkingRecordEntities.parallelStream().map(parkingRecordEntity -> parkingRecordEntity.toDto()).toList();
    }

    private Integer convertSecondsToMinutesRoundUp(Long secondsParked){
        Long totalMins = secondsParked/60;
        // an extra second counts as a minute.
        if(secondsParked%60 > 0){
            return Math.toIntExact(totalMins + 1);
        }
        return Math.toIntExact(totalMins);
    }
}
