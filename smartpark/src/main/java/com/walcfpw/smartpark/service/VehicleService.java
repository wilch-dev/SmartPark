package com.walcfpw.smartpark.service;

import com.walcfpw.smartpark.data.dto.VehicleDto;

import java.util.List;

public interface VehicleService {

    VehicleDto registerVehicle(VehicleDto vehicleDto) throws Exception;
    VehicleDto findRegisteredVehicleByLicensePlate(VehicleDto vehicleDto) throws Exception;
    List<VehicleDto> getAllRegisteredVehicles() throws Exception;
}
