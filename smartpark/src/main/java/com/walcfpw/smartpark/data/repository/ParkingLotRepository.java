package com.walcfpw.smartpark.data.repository;

import com.walcfpw.smartpark.data.repository.entities.ParkingLotEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParkingLotRepository extends JpaRepository<ParkingLotEntity, String> {
}
