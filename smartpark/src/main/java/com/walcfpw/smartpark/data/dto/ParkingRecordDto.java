package com.walcfpw.smartpark.data.dto;

import com.walcfpw.smartpark.data.repository.entities.ParkingRecordEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ParkingRecordDto {

    private Long id;
    private String lotId;
    private String licensePlate;
    private LocalDateTime in;
    private LocalDateTime out;
    private Double amountCharged;

    public ParkingRecordEntity toEntity(){
        return ParkingRecordEntity.builder()
                .id(this.id)
//                .parkingLotEntity(this.lotId)
//                .vehicleEntity(this.licensePlate)
                .timeIn(this.in)
                .timeOut(this.out)
                .amountCharged(this.amountCharged)
                .build();
    }
}
