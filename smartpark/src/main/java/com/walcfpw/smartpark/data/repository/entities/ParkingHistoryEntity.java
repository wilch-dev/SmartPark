package com.walcfpw.smartpark.data.repository.entities;

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
@Table(name = "parking_history")
@Entity
public class ParkingHistoryEntity {

    @Id
    Long id;

    @ManyToOne
    @JoinColumn(name = "parking_lot", nullable = false)
    ParkingLotEntity parkingLotEntity;

    @ManyToOne
    @JoinColumn(name = "vehicle", nullable = false)
    VehicleEntity vehicleEntity;

    LocalDateTime in;
    LocalDateTime out;

    Double amountCharged;

}
