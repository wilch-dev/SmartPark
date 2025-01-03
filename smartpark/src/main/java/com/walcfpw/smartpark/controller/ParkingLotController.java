package com.walcfpw.smartpark.controller;

import com.walcfpw.smartpark.data.dto.ParkingLotDto;
import com.walcfpw.smartpark.service.ParkingLotService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/parking-lot")
public class ParkingLotController {

    private final ParkingLotService parkingLotService;

    @PostMapping("/register")
    ParkingLotDto registerParkingLot(@RequestBody ParkingLotDto parkingLotDto) throws Exception {
        return parkingLotService.registerParkingLot(parkingLotDto);
    }

    @GetMapping("/find")
    ParkingLotDto findParkingLot(@RequestBody ParkingLotDto parkingLotDto) throws Exception {
        return parkingLotService.findParkingLotById(parkingLotDto);
    }

    @GetMapping("/all")
    List<ParkingLotDto> getAllParkingLots() throws Exception {
        return parkingLotService.getAllParkingLots();
    }

}
