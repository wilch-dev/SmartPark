package com.walcfpw.smartpark.data.dto;

import com.walcfpw.smartpark.data.enums.VehicleType;
import com.walcfpw.smartpark.data.repository.entities.VehicleEntity;
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
    private String vehicleType;
    private String ownerName;

    public VehicleEntity toEntity(){
        return VehicleEntity.builder()
                .licensePlate(this.licensePlate)
                .vehicleType(VehicleType.valueOf(this.vehicleType))
                .ownerName(this.ownerName)
                .build();
    }
}
