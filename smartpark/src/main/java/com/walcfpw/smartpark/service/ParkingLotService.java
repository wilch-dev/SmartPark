package com.walcfpw.smartpark.service;


import com.walcfpw.smartpark.data.dto.ParkingLotDto;
import com.walcfpw.smartpark.errors.CostPerMinuteException;
import com.walcfpw.smartpark.errors.ParkingLotIdExistsException;
import com.walcfpw.smartpark.errors.ParkingLotIdTooLongException;
import com.walcfpw.smartpark.errors.TotalCapacityException;

public interface ParkingLotService {

    ParkingLotDto registerParkingLot(ParkingLotDto parkingLotDto) throws ParkingLotIdExistsException, TotalCapacityException, CostPerMinuteException, ParkingLotIdTooLongException;

}
