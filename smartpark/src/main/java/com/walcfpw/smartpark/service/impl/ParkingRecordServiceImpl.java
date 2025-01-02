package com.walcfpw.smartpark.service.impl;

import com.walcfpw.smartpark.data.dto.ParkingLotDto;
import com.walcfpw.smartpark.data.dto.ParkingRecordDto;
import com.walcfpw.smartpark.data.dto.VehicleDto;
import com.walcfpw.smartpark.data.repository.ParkingRecordRepository;
import com.walcfpw.smartpark.data.repository.entities.ParkingRecordEntity;
import com.walcfpw.smartpark.service.ParkingLotService;
import com.walcfpw.smartpark.service.ParkingRecordService;
import com.walcfpw.smartpark.service.VehicleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
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
        Optional <ParkingRecordEntity> parkingRecordEntityInDb =
                parkingRecordRepository.findLatestIn(vehicleInDb.getLicensePlate());
        if (parkingRecordEntityInDb.isPresent() && Objects.isNull(parkingRecordEntityInDb.get().getTimeOut())){
            throw new Exception("Currently Parked.");
        }
        // check if vehicle license parked and is active based on date out
        // check if car is never parked
        // query other repo
        ParkingLotDto parkingLotInDb = parkingLotService.findParkingLotById(ParkingLotDto.builder().lotId(parkingRecordDto.getLotId()).build());
//        VehicleDto vehicleInDb = vehicleService.findRegisteredVehicleByLicensePlate(VehicleDto.builder().licensePlate(parkingRecordDto.getLicensePlate()).build());
        ParkingRecordEntity parkingRecordEntityToSave = ParkingRecordEntity.builder()
                .parkingLotEntity(parkingLotInDb.toEntity())
                .vehicleEntity(vehicleInDb.toEntity())
                .timeIn(LocalDateTime.now())
                .build();


        return parkingRecordRepository.save(parkingRecordEntityToSave).toDto();
    }

    @Override
    public ParkingRecordDto timeOut(ParkingRecordDto parkingRecordDto) throws Exception {
        return null;
    }

    @Override
    public List<ParkingRecordDto> getAllParkingRecords() throws Exception {
        return List.of();
    }
}
