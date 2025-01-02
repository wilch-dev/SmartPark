package com.walcfpw.smartpark.data.dto;

import com.walcfpw.smartpark.data.enums.VehicleType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class VehicleDto {
    private String licensePlate;
    private VehicleType vehicleType;
    private String ownerName;
}
