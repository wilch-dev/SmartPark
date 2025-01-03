package com.walcfpw.smartpark.data.repository.entities;

import com.walcfpw.smartpark.data.dto.ParkingRecordDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Table(name = "parking_record")
@Entity
public class ParkingRecordEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @ManyToOne
    @JoinColumn(name = "parking_lot", nullable = false)
    ParkingLotEntity parkingLotEntity;

    @ManyToOne
    @JoinColumn(name = "vehicle", nullable = false)
    VehicleEntity vehicleEntity;

    LocalDateTime timeIn;
    LocalDateTime timeOut;

    Double amountCharged;

    public ParkingRecordDto toDto(){
        return ParkingRecordDto.builder()
                .id(this.id)
                .lotId(this.parkingLotEntity.getLotId())
                .licensePlate(this.vehicleEntity.getLicensePlate())
                .in(this.timeIn)
                .out(this.timeOut)
                .amountCharged(this.amountCharged)
                .build();
    }
}
