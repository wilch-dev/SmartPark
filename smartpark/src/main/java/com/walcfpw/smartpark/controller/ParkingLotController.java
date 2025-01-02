package com.walcfpw.smartpark.controller;

import com.walcfpw.smartpark.data.dto.ParkingLotDto;
import com.walcfpw.smartpark.errors.CostPerMinuteException;
import com.walcfpw.smartpark.errors.ParkingLotIdExistsException;
import com.walcfpw.smartpark.errors.ParkingLotIdTooLongException;
import com.walcfpw.smartpark.errors.TotalCapacityException;
import com.walcfpw.smartpark.service.ParkingLotService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ParkingLotController {

    private final ParkingLotService parkingLotService;

    @PostMapping("/parking-lot/register")
    ParkingLotDto registerParkingLot(@RequestBody ParkingLotDto parkingLotDto) throws CostPerMinuteException, TotalCapacityException, ParkingLotIdExistsException, ParkingLotIdTooLongException {
        return parkingLotService.registerParkingLot(parkingLotDto);
    }

}
