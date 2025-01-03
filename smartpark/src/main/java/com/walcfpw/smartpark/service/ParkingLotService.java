package com.walcfpw.smartpark.service;


import com.walcfpw.smartpark.data.dto.ParkingLotDto;

import java.util.List;

public interface ParkingLotService {

    ParkingLotDto registerParkingLot(ParkingLotDto parkingLotDto) throws Exception;
    ParkingLotDto findParkingLotById(ParkingLotDto parkingLotDto) throws Exception;
    List<ParkingLotDto> getAllParkingLots() throws Exception;

    ParkingLotDto increaseOccupiedSlots(ParkingLotDto parkingLotDto) throws Exception;

    ParkingLotDto decreaseOccupiedSlots(ParkingLotDto parkingLotDto) throws Exception;
}
