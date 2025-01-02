package com.walcfpw.smartpark.data.repository;

import com.walcfpw.smartpark.data.repository.entities.ParkingRecordEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ParkingRecordRepository extends JpaRepository<ParkingRecordEntity, Long> {
    // query designed for H2
    @Query(value = "SELECT * FROM parking_record p WHERE p.vehicle=:licensePlate ORDER BY time_in DESC LIMIT 1", nativeQuery = true)
    Optional<ParkingRecordEntity> findLatestRecordOfLicensePlateBasedOnTimeIn(@Param("licensePlate") String licensePlate);
}
