package com.walcfpw.smartpark.controller;

import com.walcfpw.smartpark.data.dto.ParkingRecordDto;
import com.walcfpw.smartpark.service.ParkingRecordService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/record")
public class ParkingRecordActionsController {

    private final ParkingRecordService parkingRecordService;

    @PostMapping("/in")
    ParkingRecordDto timeIn(@RequestBody ParkingRecordDto parkingRecordDto) throws Exception {
        return parkingRecordService.timeIn(parkingRecordDto);
    }

    @PutMapping("/out")
    ParkingRecordDto timeOut(@RequestBody ParkingRecordDto parkingRecordDto) throws Exception {
        return parkingRecordService.timeOut(parkingRecordDto);
    }

    @PutMapping("/all")
    List<ParkingRecordDto> getAllRecords() throws Exception {
        return parkingRecordService.timeOut(parkingRecordDto);
    }

}
