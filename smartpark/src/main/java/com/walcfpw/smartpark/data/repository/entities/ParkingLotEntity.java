package com.walcfpw.smartpark.data.repository.entities;

import com.walcfpw.smartpark.data.dto.ParkingLotDto;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Table(name = "parking_lot")
@Entity
public class ParkingLotEntity {
    @Column(unique=true, length = 50)
    @Id
    String lotId;
    @Column(nullable = false)
    String location;
    @Column(nullable = false)
    Integer totalCapacity;
    Integer currentlyOccupiedSlots;
    Double costPerMinute;

    public ParkingLotDto toDto(){
        return ParkingLotDto.builder()
                .lotId(this.lotId)
                .location(this.location)
                .totalCapacity(this.totalCapacity)
                .currentlyOccupiedSlots(this.currentlyOccupiedSlots)
                .costPerMinute(this.costPerMinute)
                .build();
    }

}
