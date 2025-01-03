package com.walcfpw.smartpark.controller;

import com.walcfpw.smartpark.data.dto.VehicleDto;
import com.walcfpw.smartpark.service.VehicleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/vehicle")
public class VehicleController {
    private final VehicleService vehicleService;

    @PostMapping("/register")
    VehicleDto registerVehicle(@RequestBody VehicleDto vehicleDto) throws Exception {
        return vehicleService.registerVehicle(vehicleDto);
    }

    @GetMapping("/find")
    VehicleDto findVehicleByLicensePlate(@RequestBody VehicleDto vehicleDto) throws Exception {
        return vehicleService.findRegisteredVehicleByLicensePlate(vehicleDto);
    }

    @GetMapping("/all")
    List<VehicleDto> getAllRegisteredVehicles() throws Exception {
        return vehicleService.getAllRegisteredVehicles();
    }
}
