package com.walcfpw.smartpark.controller;

import com.walcfpw.smartpark.data.dto.ParkingLotDto;
import com.walcfpw.smartpark.service.ParkingLotService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ParkingLotController {

    private final ParkingLotService parkingLotService;

    @PostMapping("/parking-lot/register")
    ParkingLotDto registerParkingLot(@RequestBody ParkingLotDto parkingLotDto) throws Exception {
        return parkingLotService.registerParkingLot(parkingLotDto);
    }

    @PostMapping("/parking-lot/find")
    ParkingLotDto findParkingLot(@RequestBody ParkingLotDto parkingLotDto) throws Exception {
        return parkingLotService.findParkingLot(parkingLotDto);
    }

    @GetMapping("/parking-lot/all")
    List<ParkingLotDto> getAllParkingLots() throws Exception {
        return parkingLotService.getAllParkingLots();
    }

}
