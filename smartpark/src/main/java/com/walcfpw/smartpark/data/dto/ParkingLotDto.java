package com.walcfpw.smartpark.data.dto;


import com.walcfpw.smartpark.data.repository.entities.ParkingLotEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ParkingLotDto {
    private String lotId;
    private String location;
    private Integer totalCapacity;
    private Integer currentlyOccupiedSlots;
    private Double costPerMinute;

    public ParkingLotEntity toEntity(){
        return ParkingLotEntity.builder()
                .lotId(this.lotId)
                .location(this.location)
                .totalCapacity(this.totalCapacity)
                .currentlyOccupiedSlots(this.currentlyOccupiedSlots)
                .costPerMinute(this.costPerMinute)
                .build();
    }
}
