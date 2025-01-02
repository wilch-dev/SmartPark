package com.walcfpw.smartpark.data.repository.entities;

import jakarta.persistence.*;
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
}
