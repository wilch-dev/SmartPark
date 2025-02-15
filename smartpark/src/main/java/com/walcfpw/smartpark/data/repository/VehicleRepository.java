package com.walcfpw.smartpark.data.repository;

import com.walcfpw.smartpark.data.repository.entities.VehicleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleRepository extends JpaRepository<VehicleEntity, String> {
}
