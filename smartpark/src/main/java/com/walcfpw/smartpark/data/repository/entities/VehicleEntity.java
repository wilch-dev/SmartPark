package com.walcfpw.smartpark.data.repository.entities;

import com.walcfpw.smartpark.data.enums.VehicleType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Table(name = "vehicle")
@Entity
public class VehicleEntity {

    @Column(unique=true, length = 50)
    @Id
    String licensePlate;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    VehicleType vehicleType;

    @Column(nullable = false)
    String ownerName;
}
